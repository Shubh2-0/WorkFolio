package com.workfolio.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.workfolio.entity.Employee;
import com.workfolio.exception.EmployeeException;

public interface EmployeeService {

	public void addEmployee(Employee e) throws EmployeeException;
	
	public void updateEmployee(Employee e) throws EmployeeException;

	public List<Employee> getAllEmployee() throws EmployeeException;

	public Employee getEmployeeById(int id) throws EmployeeException;

	public void deleteEmployee(int id) throws EmployeeException;

	public Page<Employee> getEmployeeByPaginate(int currentPage, int size) throws EmployeeException;
	
	public void trimProperties(Employee emp);

}
