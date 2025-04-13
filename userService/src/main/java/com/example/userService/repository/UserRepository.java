package com.example.userService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.userService.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, String>{

}
