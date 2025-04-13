package com.example.userService.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.userService.responseDto.Rating;

@FeignClient(name="RATING-SERVICE")
public interface RatingServiceClient {
	
	@GetMapping("rating/user/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId);

}
