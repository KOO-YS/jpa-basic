package com.example.demo.domain;

import com.example.demo.domain.composite.FriendGroupMemberPrimaryKey;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class FriendGroupMember implements Serializable {
    @Id
    @MapsId("userId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private long userId;

    @Id
    @MapsId("groupId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private long groupId;

    @Id
    @MapsId("userId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private long friendId;


}
