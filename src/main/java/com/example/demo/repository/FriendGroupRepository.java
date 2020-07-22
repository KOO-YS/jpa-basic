package com.example.demo.repository;

import com.example.demo.domain.FriendGroup;
import com.example.demo.domain.composite.FriendGroupPrimaryKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendGroupRepository extends JpaRepository<FriendGroup, FriendGroupPrimaryKey> {
}
