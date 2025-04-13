package com.example.userService.responseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Hotels {
	
	
	private String hotelId;
	private String name;
	private String location;
	private String about;

}
