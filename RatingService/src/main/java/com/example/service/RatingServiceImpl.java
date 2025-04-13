package com.example.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Rating;
import com.example.repository.RatingRepository;

@Service
public class RatingServiceImpl implements RatingService{
	
	@Autowired
	private RatingRepository ratingRepository;

	@Override
	public Rating createRating(Rating rating) {
		
		String ratingId ="RatingID_"+UUID.randomUUID().toString();
		rating.setRatingId(ratingId);
		
		return this.ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getAll() {
		
		return this.ratingRepository.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {

		return this.ratingRepository.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		return this.ratingRepository.findByHotelId(hotelId);
	}
	
	

}
