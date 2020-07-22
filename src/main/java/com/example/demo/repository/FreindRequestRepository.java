package com.example.demo.repository;

import com.example.demo.domain.FriendRequest;
import com.example.demo.domain.composite.FriendRequestPrimaryKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FreindRequestRepository extends JpaRepository<FriendRequest, FriendRequestPrimaryKey> {
}
