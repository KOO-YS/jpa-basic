package com.example.demo.repository;

import com.example.demo.domain.Friend;
import com.example.demo.domain.composite.FriendPrimaryKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendRepository extends JpaRepository<Friend, FriendPrimaryKey> {
}
