package com.example.userService.service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.userService.client.HotelServiceClient;
import com.example.userService.client.RatingServiceClient;
import com.example.userService.entity.Users;
import com.example.userService.exception.ResourceNotFoundException;
import com.example.userService.repository.UserRepository;
import com.example.userService.responseDto.Hotels;
import com.example.userService.responseDto.Rating;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RatingServiceClient ratingServiceClient;
	
	@Autowired
	private HotelServiceClient hotelServiceClient;

	@Override
	public Users saveUser(Users users) {
		users.setUserId("USER_ID_"+UUID.randomUUID().toString());
		return this.userRepository.save(users);
	}

	@Override
	public List<Users> getAllUsers() {
		return  this.userRepository.findAll();
	}

	@Override
	public Users getUser(String userId) {

		Users user=  this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User Not FOund : "+userId));
	    List<Rating> ratingListOfUser = this.ratingServiceClient.getRatingByUserId(userId).getBody();
	    
	 List<Rating> ratingList  = ratingListOfUser.stream().map(rating ->{
	     Hotels hotel	=this.hotelServiceClient.getAllHotels(rating.getHotelId()).getBody();
	     rating.setHotels(hotel);
	     return rating;
	    }).collect(Collectors.toList());
	 
	    user.setRating(ratingList);
	    
	    return user;
	
	}

}
