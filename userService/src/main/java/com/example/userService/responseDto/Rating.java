package com.example.userService.responseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Rating {
	
	private String ratingId;
	private String userId;
	private String hotelId;
	private Integer rating;
	private String feedback;
	private Hotels hotels;

}
