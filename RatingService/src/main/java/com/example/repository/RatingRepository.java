package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Rating;
import java.util.List;


@Repository
public interface RatingRepository extends JpaRepository<Rating, String>{
	
	List<Rating> findByHotelId(String hotelId);
	
	List<Rating> findByUserId(String userId);

}
