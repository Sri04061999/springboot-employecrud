package com.sridhar.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.sridhar.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{
	List<Employee> findByName(String name);
}
