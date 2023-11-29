package com.sridhar.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sridhar.employee.entity.Employee;
import com.sridhar.employee.helper.ResponseStructure;
import com.sridhar.employee.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class MyController {

	@Autowired
	EmployeeService service;

	@PostMapping
	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<ResponseStructure<Employee>>(service.saveEmployee(employee), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Employee>>> fetchAll()
	{
		return new ResponseEntity<ResponseStructure<List<Employee>>>(service.fetchAll(),HttpStatus.FOUND);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Employee>> findEmployeeID(@PathVariable int id) {
		return new ResponseEntity<ResponseStructure<Employee>>(service.findEmployee(id), HttpStatus.FOUND);
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<ResponseStructure<List<Employee>>> fetchByName(@PathVariable String name)
	{
		return new ResponseEntity<ResponseStructure<List<Employee>>>(service.fetchByName(name),HttpStatus.FOUND);
	}
	
	
}
