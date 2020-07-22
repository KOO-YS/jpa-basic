package com.example.demo.domain;

import com.example.demo.domain.composite.FriendGroupPrimaryKey;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@IdClass(FriendGroupPrimaryKey.class)
@Entity
public class FriendGroup{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long groupId;

    @Id
    @MapsId("userId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private long userId;

    private String groupName;

    // 그룹멤버 클래스 아이디
    @OneToMany(cascade = {CascadeType.PERSIST}, orphanRemoval = true)
    @JoinColumns({
            @JoinColumn(name = "groupId"),
            @JoinColumn(name = "userId")
    })
    private Set<FriendGroupMember> userGroup = new HashSet<>();
}
