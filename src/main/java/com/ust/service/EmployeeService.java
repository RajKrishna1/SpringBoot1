package com.ust.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ust.dao.EmployeeRepository;
import com.ust.model.Employee;
@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	public Employee addNewEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	public Employee addNewUpdateEmployee(Employee employee) {
		  return employeeRepository.save(employee);
		 }

		 // select
		 public List<Employee> getAllEmployess() {
		  return employeeRepository.findAll();
		 }

		 // select * from where id=?
		 public Employee getEmployeeById(int empid) {
		  // java 8 - Null values
		  Optional<Employee> employee = employeeRepository.findById(empid);
		  if (employee.isPresent()) {
		   return employee.get();
		  }
		  return null;
		 }

		 // delete
		 public void deleteEmployee(int empid) {
		  employeeRepository.deleteById(empid);
		 }
		 public boolean employeeExistsOrNot(int id) {
			 return   employeeRepository.existsById(id);
		 }
		 
}