package com.example.demo.domain.composite;

import javax.persistence.IdClass;
import java.io.Serializable;

public class FriendGroupMemberPrimaryKey implements Serializable {
    private long userId;
    private long groupId;
    private long friendId;

}
