package com.example.demo.controller;

import com.example.demo.domain.Friend;
import com.example.demo.domain.User;
import com.example.demo.repository.FriendRepository;
import com.example.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class UserController {

    private UserRepository userRepository;
    private FriendRepository friendRepository;

    @GetMapping("/")
    public String test(){
        return "hello";
    }

    @GetMapping("/all")
    public List<User> getUsers(){
        System.out.println("검색");
        List<User> list = userRepository.findAll();
        for(User u : list){
            System.out.println(u.getUserId());
        }
        return list;
    }

    @PutMapping("/add")
    public User create(@RequestBody User user){
        User newuser = userRepository.save(user);
        System.out.println("생성");
        return newuser;
    }

    @PutMapping("/request/{id}/{fid}")
    public Friend requestFriend(@PathVariable long id, @PathVariable long fid){
        Friend friend = new Friend();
        friend.setUserId(id);
        friend.setFriendId(fid);
        friendRepository.save(friend);
        System.out.println("친구 성공"+id+"/"+fid);
        return friend;
    }

}
