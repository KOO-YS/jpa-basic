package com.example.demo.domain;

import com.example.demo.domain.composite.FriendRequestPrimaryKey;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@IdClass(FriendRequestPrimaryKey.class)
public class FriendRequest {

    @Id
    @MapsId("userId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Long userId1;

    @Id
    @MapsId("userId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Long userId2;

    private AcceptStatus acceptStatus;
}

enum AcceptStatus{
    REQUEST, ACCEPT
}