package com.example.userService.service;

import java.util.List;

import com.example.userService.entity.Users;

public interface UserService {
	
	Users saveUser(Users users);
	
	List<Users> getAllUsers();
	
	//Users getUser(String userId);

	Users getUser(String userId);

}
