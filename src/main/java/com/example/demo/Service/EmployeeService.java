package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.EmployeeEntity;

public interface EmployeeService {
	
	public EmployeeEntity saveEmployee(EmployeeEntity employee);
	public EmployeeEntity updateEmployee(EmployeeEntity employee);
	void deleteEmployee(Long id);
	public List<EmployeeEntity> getAllEmployee();

}
