package com.example.demo.domain.composite;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class FriendRequestPrimaryKey implements Serializable {
    private Long userId1;
    private Long userId2;
}

