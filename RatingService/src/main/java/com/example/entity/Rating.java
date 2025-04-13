package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="Rating")
public class Rating {
	
	@Id
	private String ratingId;
	@Column
	private String  userId;
	@Column
	private String  hotelId;
	@Column
	private Integer rating;
	@Column
	private String feedback;

}
