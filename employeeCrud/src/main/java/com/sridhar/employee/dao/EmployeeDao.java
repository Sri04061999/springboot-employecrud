package com.sridhar.employee.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sridhar.employee.entity.Employee;
import com.sridhar.employee.exception.DataNotFoundException;
import com.sridhar.employee.repository.EmployeeRepository;

@Repository
public class EmployeeDao {
	
	@Autowired
	EmployeeRepository repository;

	public Employee saveEmployee(Employee employee) {
		return repository.save(employee);
	}

	public List<Employee> fetchAll() {
		return repository.findAll();
	}

	public Employee findById(int id) {
		return repository.findById(id).orElseThrow(()->new DataNotFoundException("Data Not FOund WIth id "+id));
	}

	public List<Employee> fetchByName(String name) {
		return repository.findByName(name);
	}

}
