package com.example.controller;

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

import com.example.entity.Rating;
import com.example.service.RatingService;

@RestController
@RequestMapping("/rating")
public class RatingController {
	
	@Autowired
	private RatingService ratingService;
	
	@PostMapping
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.ratingService.createRating(rating));  
	}
	
	@GetMapping
    public ResponseEntity<List<Rating>> getAll(){
		
		return ResponseEntity.status(HttpStatus.OK).body(this.ratingService.getAll());  
		
	}
	
	@GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId){
		
		return ResponseEntity.status(HttpStatus.OK).body(this.ratingService.getRatingByHotelId(hotelId));  
		
	}
	
	@GetMapping("/user/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId){
		
		return ResponseEntity.status(HttpStatus.OK).body(this.ratingService.getRatingByUserId(userId));  
		
	}

}
