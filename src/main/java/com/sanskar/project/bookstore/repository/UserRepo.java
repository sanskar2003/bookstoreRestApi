package com.sanskar.project.bookstore.repository;

import com.sanskar.project.bookstore.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Long> {
    public UserEntity findByUsername(String username);
}
