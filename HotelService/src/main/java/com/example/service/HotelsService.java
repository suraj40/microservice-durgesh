package com.example.service;

import java.util.List;

import com.example.entity.Hotels;

public interface HotelsService {
	
	Hotels createHotels(Hotels hotels);
	
	List<Hotels> getAllHotels();
	
	Hotels getHotelsById(String hotelId);
	
	

}
