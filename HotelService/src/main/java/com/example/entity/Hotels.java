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
@Table(name = "HOTELS")
public class Hotels {
	
	@Id
	private String hotelId;
	@Column
	private String name;
	@Column
	private String location;
	@Column
	private String about;

}
