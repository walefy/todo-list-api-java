package com.walefy.todospringboot.user;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, UUID> {
    UserModel findByUsername(String username);
    List<UserModel> findAll();
    
    @Override
    default void deleteById(UUID id) {
        findById(id).ifPresent(entity -> delete(entity));
    }
}