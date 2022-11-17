package com.felipebs.moneyeasy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.felipebs.moneyeasy.models.Employee;
import com.felipebs.moneyeasy.repository.IEmployeeRepository;

@Service
public class EmployeeService extends ServiceGlobal {
	
	@Autowired
	IEmployeeRepository employeeRepository;
	
	public Employee paginationEmployee(Integer page, Integer elementPerPage, String keywordsToSearch) {
		
		return employeeRepository.paginationEmployee(uString.formatStringRepository(keywordsToSearch), PageRequest.of(page, elementPerPage));
	}
}
