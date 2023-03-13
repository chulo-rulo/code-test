package com.capgemini.blablacap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.blablacap.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
