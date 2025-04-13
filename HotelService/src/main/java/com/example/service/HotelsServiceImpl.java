package com.example.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Hotels;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.HotelsRepository;

@Service
public class HotelsServiceImpl implements HotelsService{
	
	@Autowired
	private HotelsRepository hotelsRepository;

	@Override
	public Hotels createHotels(Hotels hotel) {
		String hotelId = "HotelId_"+UUID.randomUUID().toString();
		hotel.setHotelId(hotelId);
		return this.hotelsRepository.save(hotel);
	}

	@Override
	public List<Hotels> getAllHotels() {
		// TODO Auto-generated method stub
		return this.hotelsRepository.findAll();
	}

	@Override
	public Hotels getHotelsById(String hotelId) {
		// TODO Auto-generated method stub
		return this.hotelsRepository.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("Hotel with given Id not Found !"));
	}

}
