package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@IdClass(FriendPrimaryKey.class)
@Entity
public class Friend implements Serializable {

    @Id
    @MapsId("userId")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Long userId;

    @Id
    @MapsId("userId")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Long friendId;

}
