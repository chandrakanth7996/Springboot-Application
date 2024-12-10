package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.EmployeeEntity;
import com.example.demo.Repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void deleteEmployee(Long id) {
		if(employeeRepository.existsById(id)) {
			employeeRepository.deleteById(id);
		} else {
			throw new IllegalArgumentException("Employee not found "+ id);
		}
		
	}

	@Override
	public EmployeeEntity saveEmployee(EmployeeEntity employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public EmployeeEntity updateEmployee(EmployeeEntity employee) {
		// Check if the employee exists
        Optional<EmployeeEntity> existingEmployee = employeeRepository.findById(employee.getEmpId());
        
        if (existingEmployee.isPresent()) {
            EmployeeEntity updatedEmployee = existingEmployee.get();
            updatedEmployee.setEmployeeName(employee.getEmployeeName());
            updatedEmployee.setDesignation(employee.getDesignation());
            updatedEmployee.setSalary(employee.getSalary());
            
            // Save the updated employee entity
            return employeeRepository.save(updatedEmployee);
        } else {
            throw new IllegalArgumentException("Employee not found for ID: " + employee.getEmpId());
        }
	}

	@Override
	public List<EmployeeEntity> getAllEmployee() {
		return employeeRepository.findAll();
	}

}
