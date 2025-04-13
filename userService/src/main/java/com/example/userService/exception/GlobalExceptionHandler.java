package com.example.userService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.userService.responseDto.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(ResourceNotFoundException.class)
	ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException ex){
		
	ApiResponse apiResponse = ApiResponse.builder().message(ex.getMessage()).success(true).status(HttpStatus.NOT_FOUND).build();
		
    return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
	}

}
