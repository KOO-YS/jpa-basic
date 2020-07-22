package com.example.demo.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    // 친구 Friend
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy="userId", orphanRemoval = true)
    private Set<Friend> makefriend = new HashSet<>();

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy="friendId", orphanRemoval = true)
    private Set<Friend> becomeFriend = new HashSet<>();

    // 친구 신청 Friend Request
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy="userId1", orphanRemoval = true)
    private Set<FriendRequest> user1 = new HashSet<>();

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy="userId2", orphanRemoval = true)
    private Set<FriendRequest> user2 = new HashSet<>();

    // 유저 그룹
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy="userId", orphanRemoval = true)
    private Set<FriendGroup> userGroup = new HashSet<>();

    // 유저 친구 그룹 속한 친구
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy="userId", orphanRemoval = true)
    private Set<FriendGroupMember> groupOwner = new HashSet<>();

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy="friendId", orphanRemoval = true)
    private Set<FriendGroupMember> groupMember = new HashSet<>();


    //https://m.blog.naver.com/PostView.nhn?blogId=rorean&logNo=221466846173&proxyReferer=https:%2F%2Fwww.google.com%2F
}
