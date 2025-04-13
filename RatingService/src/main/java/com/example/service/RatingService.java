package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.Rating;


public interface RatingService {
	
	
	Rating createRating(Rating rating);
	
	List<Rating> getAll();
	
	List<Rating> getRatingByUserId(String userId);
	
	List<Rating> getRatingByHotelId(String hotelId);

}
