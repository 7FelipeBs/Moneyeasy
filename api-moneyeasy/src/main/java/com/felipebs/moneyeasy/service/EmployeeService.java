package com.felipebs.moneyeasy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.felipebs.moneyeasy.models.Employee;
import com.felipebs.moneyeasy.repository.IEmployeeRepository;
import com.felipebs.moneyeasy.utility.UString;

@Service
public class EmployeeService {
	
	@Autowired
	IEmployeeRepository employeeRepository;
	
	@Autowired
	UString utilityString;
	
	public Employee paginationEmployee(Integer page, Integer size, String keywordsToSearch) {
		return employeeRepository.paginationEmployee(utilityString.formatStringRepository(keywordsToSearch), PageRequest.of(page, size));
	}
	
	public Employee save (Employee entity) {
		return employeeRepository.save(entity);
	}
	
	public Employee update (Employee entity) {
		return employeeRepository.save(entity);
	}
	
	public void delete (Long id) {
		 employeeRepository.deleteById(id);
	}
}
