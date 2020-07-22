package com.example.demo.controller;

import com.example.demo.service.OauthService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Controller
public class OauthController {

//    @Autowired
    private OauthService oauthService;

    /**
     * 카카오 로그인 동의 화면을 호출하고, 사용자 동의를 거쳐 인증 코드 발급을 요청하는 API
     */
    @RequestMapping(value="/oauth", method = RequestMethod.GET)
    public String getAuthorizeCode() {

        String appKey = "276ef22491e2971006db8f2ce046d690";
        String redirectURI = "http://localhost:8080/login";

        StringBuffer url = new StringBuffer();
        url.append("https://kauth.kakao.com/oauth/authorize?");
        url.append("client_id=" + appKey);
        url.append("&redirect_uri="+redirectURI);
        url.append("&response_type=code");

        return "redirect:" + url.toString();
    }

    @ResponseBody
    @RequestMapping(value = "/login",produces = "application/json", method = {RequestMethod.GET,RequestMethod.POST})
    public String login(@RequestParam("code")String code,RedirectAttributes ra,HttpSession session,HttpServletResponse response) throws IOException{
        System.out.println("code"+code);
        JsonNode accessToken = getKakaoAccessToken(code);
        JsonNode userInfo = getKakaoInfo(accessToken.get("access_token"));

        String userId = userInfo.get("id").asText();
//        String userName =
        System.out.println("내 아이디 출력 : "+userId);
        // https://developers.kakao.com/docs/latest/ko/user-mgmt/rest-api
        return userId;
    }

    public JsonNode getKakaoAccessToken(String code) {
        String appKey = "276ef22491e2971006db8f2ce046d690";
        String redirectURI = "http://localhost:8080/login";
        String requestURI = "https://kauth.kakao.com/oauth/token";

        Map<String, String> info = new HashMap<String, String>();
        info.put("grant_type", "authorization_code");
        info.put("client_id", appKey);
        info.put("redirect_uri", redirectURI);
        info.put("code",code);

        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(requestURI);

        final List<NameValuePair> postParams = new ArrayList<>();

        postParams.add(new BasicNameValuePair("grant_type", "authorization_code"));
        postParams.add(new BasicNameValuePair("client_id", appKey)); // REST API KEY
        postParams.add(new BasicNameValuePair("redirect_uri",redirectURI));
        postParams.add(new BasicNameValuePair("code",code));

        JsonNode returnNode = null;
        try {
            post.setEntity(new UrlEncodedFormEntity(postParams));
            post.setHeader("Content-Type" ,"application/x-www-form-urlencoded;charset=utf-8");
            HttpResponse response = client.execute(post);
            final int responseCode = response.getStatusLine().getStatusCode();

            System.out.println("\nSending 'POST' request to URL : " + requestURI);
            System.out.println("Post parameters : " + postParams);
            System.out.println("Response Code : " + responseCode);

            // JSON 형태 반환값 처리
            ObjectMapper mapper = new ObjectMapper();

            returnNode = mapper.readTree(response.getEntity().getContent());

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return returnNode;
    }
    public JsonNode getKakaoInfo(JsonNode accessToken){

        String requestURI = "https://kapi.kakao.com/v1/user/access_token_info";

        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet(requestURI);
        get.addHeader("Authorization","Bearer " + accessToken);

        JsonNode returnNode = null;
        try {
            HttpResponse response = client.execute(get);
            int responseCode = response.getStatusLine().getStatusCode();
            String msg=response.getStatusLine().getReasonPhrase();

            System.out.println("\nSending 'GET' request to URL : " + requestURI);
            System.out.println("Response Code : " + responseCode);
            System.out.println("Response Code : " + msg);

            ObjectMapper mapper = new ObjectMapper();
            returnNode = mapper.readTree(response.getEntity().getContent());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return returnNode;
    }
}
