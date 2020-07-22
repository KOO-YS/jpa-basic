package com.example.demo.domain.composite;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Objects;

@Data
@EqualsAndHashCode
public class FriendPrimaryKey implements Serializable {
    private Long userId;
    private Long friendId;

    public FriendPrimaryKey() {
    }

    public FriendPrimaryKey(Long userId, Long friendId) {
        this.userId = userId;
        this.friendId = friendId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FriendPrimaryKey that = (FriendPrimaryKey) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(friendId, that.friendId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, friendId);
    }

}
