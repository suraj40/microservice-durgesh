package com.example.userService.responseDto;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class ApiResponse {
	
	private String message;
	private boolean success;
	private HttpStatus status;

}
