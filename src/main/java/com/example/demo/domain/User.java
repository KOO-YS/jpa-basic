package com.example.demo.domain;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class User {
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

//    @OneToMany( mappedBy="userId", cascade= CascadeType.ALL, orphanRemoval = true)
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy="userId", orphanRemoval = true)
    private Set<Friend> makefriend = new HashSet<>();

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy="friendId", orphanRemoval = true)
    private Set<Friend> becomeFriend = new HashSet<>();

    //https://m.blog.naver.com/PostView.nhn?blogId=rorean&logNo=221466846173&proxyReferer=https:%2F%2Fwww.google.com%2F
}
