package com.example.userService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.userService.entity.Users;
import com.example.userService.service.UserService;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;


@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<Users> createUser(@RequestBody Users users){
		
		Users users2 = this.userService.saveUser(users);
		return ResponseEntity.status(HttpStatus.CREATED).body(users2);
	}
	
	int retryValue =1;
	
	@GetMapping("/{userId}")
	//@CircuitBreaker(name="ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
	//@Retry(name="ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
	@RateLimiter(name="userRateLimiter",fallbackMethod = "ratingHotelFallback")
	public ResponseEntity<Users> getSingleUser(@PathVariable String userId){
		//log.info("retry value :{}", retryValue++);
	  Users users	= this.userService.getUser(userId);
	  
	  return ResponseEntity.ok(users);
	}
	
	// create Fallback Method circuit Breaker
	public ResponseEntity<Users> ratingHotelFallback(String userId,Exception ex){
		//log.debug("Fallback is executed because of service is down :{}", ex.getMessage());
		Users users = Users.builder()
				           .email("DUmmy@gmail.com")
				           .name("Dummy")
				           .userId("000000")
				           .about("This user is created because of Service is down")
				           .build();
		return ResponseEntity.ok(users);
	}
	
	
	@GetMapping
	public ResponseEntity<List<Users>> getAllUser(){
		
	  List<Users> users	= this.userService.getAllUsers();
	  
	  return ResponseEntity.ok(users);
	}

}
