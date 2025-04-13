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

import com.example.entity.Hotels;
import com.example.service.HotelsService;

@RestController
@RequestMapping("/hotel")
public class HotelsController {
	
	@Autowired
	private HotelsService hotelsService;
	
	@PostMapping
	public ResponseEntity<Hotels> createHotels(@RequestBody Hotels hotels){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.hotelsService.createHotels(hotels));
	}
	
	@GetMapping
	public ResponseEntity<List<Hotels>> getAllHotels(){
		
		return ResponseEntity.status(HttpStatus.OK).body(this.hotelsService.getAllHotels());
	}
	
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotels> getAllHotels(@PathVariable String hotelId){
		
		return ResponseEntity.status(HttpStatus.OK).body(this.hotelsService.getHotelsById(hotelId));
	}

}
