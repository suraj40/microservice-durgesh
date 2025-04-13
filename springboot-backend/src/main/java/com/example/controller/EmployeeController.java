package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Employee;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.EmployeeRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/emp")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	int id =3;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmp(){
		return this.employeeRepository.findAll();
		
	}
	
	@PostMapping("/createEmployee")
	public  Employee createEmployee(@RequestBody Employee employee){
		employee.setEmpId("emp_0"+id++);
		return this.employeeRepository.save(employee);
		
	}
	
	@GetMapping("/getEmployeeById/{empId}")
	public  ResponseEntity<Employee> getEmployeeById(@PathVariable("empId") String empId){
		
		Employee emp= this.employeeRepository
				.findById(empId)
				.orElseThrow(()-> new ResourceNotFoundException("Resouce Not Found by Id "+empId));
		
		return ResponseEntity.ok(emp);
		
	}
	
	@PutMapping("/updateEmployeeById/{empId}")
	public  ResponseEntity<Employee> updateEmployeeById(@PathVariable("empId") String empId,@RequestBody Employee employee){
		
		Employee emp= this.employeeRepository
				.findById(empId)
				.orElseThrow(()-> new ResourceNotFoundException("Resouce Not Found by Id "+empId));
		emp.setEmailId(employee.getEmailId());
		emp.setFirstName(employee.getFirstName());
		emp.setLastName(employee.getLastName());
		
	 Employee updaateEmp = this.employeeRepository.save(emp);
		
		return ResponseEntity.ok(updaateEmp);
		
	}
	

	@DeleteMapping("/deleteEmployeeById/{empId}")
	public  ResponseEntity<Employee> deleteEmployeeById(@PathVariable("empId") String empId){
		
		Employee emp= this.employeeRepository
				.findById(empId)
				.orElseThrow(()-> new ResourceNotFoundException("Resouce Not Found by Id "+empId));
		
		this.employeeRepository.delete(emp);
		
		return ResponseEntity.ok(emp);
		
	}

}
