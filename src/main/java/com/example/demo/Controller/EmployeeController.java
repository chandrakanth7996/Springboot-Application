package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.EmployeeEntity;
import com.example.demo.Service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/get")
	public ResponseEntity<List<EmployeeEntity>> getAllEmployees(){
		List<EmployeeEntity> emp = employeeService.getAllEmployee();
		return new ResponseEntity<>(emp,HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<EmployeeEntity> saveEmployee(@RequestBody EmployeeEntity employee){
		EmployeeEntity emp = employeeService.saveEmployee(employee);
		return new ResponseEntity<>(emp,HttpStatus.CREATED);
	}
	
	@PutMapping("/modify")
	public ResponseEntity<EmployeeEntity> updateEmployee(@RequestBody EmployeeEntity employee){
		EmployeeEntity emp = employeeService.updateEmployee(employee);
		return new ResponseEntity<>(emp,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable Long id){
		employeeService.deleteEmployee(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
