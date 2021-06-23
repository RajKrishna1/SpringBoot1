package com.ust.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.exception.EmployeeNotFoundException;
import com.ust.model.Employee;
import com.ust.service.EmployeeService;
@RestController    // Handle JSON/XML request and response
@RequestMapping(path="/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@PostMapping(path="addEmp")
	public ResponseEntity<Employee> addNewUpdateEmployee(@RequestBody Employee employee) {
		Employee addNewEmpoyee= employeeService.addNewEmployee(employee);
		if(addNewEmpoyee==null) {
			return new ResponseEntity<>(addNewEmpoyee, HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(addNewEmpoyee, HttpStatus.CREATED);
	}
	@GetMapping("getAllEmployee")
	public ResponseEntity<List<Employee>>getAllEmployess(){
		List<Employee> employeeList=employeeService.getAllEmployess();
		if(employeeList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new  ResponseEntity<List<Employee>>(employeeList, HttpStatus.OK);
		
	}
	@PutMapping(path="update")
	public ResponseEntity<Employee> UpdateEmployee(@RequestBody Employee employee) throws EmployeeNotFoundException {
		boolean emp = employeeService.employeeExistsOrNot(employee.getId());
	     if(!emp){
	    throw new EmployeeNotFoundException("Employee not found with id " + employee.getId() + " to delete");  
	     }

		Employee updatedEmpoyee= employeeService.addNewEmployee(employee);
		if(updatedEmpoyee==null) {
			return new ResponseEntity<>(updatedEmpoyee, HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(updatedEmpoyee, HttpStatus.CREATED);
	}
	@DeleteMapping(path="delete/{id}")
	public ResponseEntity<String>deleteEmployeeById(@PathVariable (name="id") int id) throws EmployeeNotFoundException{
//		boolean employeeIdExistorNot=employeeService.employeeExistsOrNot(id);
//		if(!employeeIdExistorNot) {
//			throw new EmployeeNotFoundException("Employee id "+ id+ " not Found.Please check the Given Id");
//		}
		
		
		employeeService.deleteEmployee(id);
		return new ResponseEntity<String>("Deleted successfully", HttpStatus.CREATED);
	
			
//		}
//	@ExceptionHandler(value = EmployeeNotFoundException.class)	
//	public ResponseEntity<String>employeeNotFoundException(EmployeeNotFoundException ex){
//		return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
//
}
	

}


