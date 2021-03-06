package com.example.demo.domain;

import com.example.demo.domain.composite.FriendPrimaryKey;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@IdClass(FriendPrimaryKey.class)
@Entity
public class Friend implements Serializable {

    @Id
    @MapsId("userId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Long userId;

    @Id
    @MapsId("userId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Long friendId;

    @OneToMany(cascade = {CascadeType.PERSIST}, orphanRemoval = true)
    @JoinColumns({
            @JoinColumn(name = "userId"),
            @JoinColumn(name = "friendId")
    })
    private Set<FriendGroupMember> groupMember = new HashSet<>();
}


