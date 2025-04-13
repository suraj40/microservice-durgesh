package com.example.userService.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.userService.responseDto.Hotels;

@FeignClient(name="HOTEL-SERVICE")
public interface HotelServiceClient {
	

	@GetMapping("hotel/{hotelId}")
	public ResponseEntity<Hotels> getAllHotels(@PathVariable String hotelId);
	
	
	

}
