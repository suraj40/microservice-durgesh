package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name="Employee")
public class Employee {
	
	@Id
	private String empId;
	private String firstName;
	private String lastName;
	private String emailId;

}
