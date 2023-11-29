package com.sridhar.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.sridhar.employee.dao.EmployeeDao;
import com.sridhar.employee.entity.Employee;
import com.sridhar.employee.exception.DataNotFoundException;
import com.sridhar.employee.helper.ResponseStructure;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDao dao;

	public ResponseStructure<Employee> saveEmployee(Employee employee) {
		// Logic

		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
		structure.setCode(HttpStatus.CREATED.value());
		structure.setMessage("Data Inserted Success");
		structure.setData(dao.saveEmployee(employee));

		return structure;
	}

	public ResponseStructure<List<Employee>> fetchAll() {
		ResponseStructure<List<Employee>> structure = new ResponseStructure<List<Employee>>();
		structure.setCode(HttpStatus.FOUND.value());
		structure.setMessage("Data Found Success");
		structure.setData(dao.fetchAll());
		return structure;
	}

	public ResponseStructure<Employee> findEmployee(int id) {
		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
		structure.setCode(HttpStatus.FOUND.value());
		structure.setMessage("Data Found Success");
		structure.setData(dao.findById(id));
		return structure;
	}

	public ResponseStructure<List<Employee>> fetchByName(String name) {
		List<Employee> list = dao.fetchByName(name);
		if (list.isEmpty()) {
			throw new DataNotFoundException("Data Not Found With Name: " + name);
		} else {
			ResponseStructure<List<Employee>> structure = new ResponseStructure<List<Employee>>();
			structure.setCode(HttpStatus.FOUND.value());
			structure.setMessage("Data Found Success");
			structure.setData(list);
			return structure;
		}
	}

}
