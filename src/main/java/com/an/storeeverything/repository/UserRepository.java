package com.an.storeeverything.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.an.storeeverything.models.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	UserEntity findByUsername(String username);
}
