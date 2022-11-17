package com.felipebs.moneyeasy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.felipebs.moneyeasy.models.Employee;
import com.felipebs.moneyeasy.service.EmployeeService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public Employee paginationEmployee (
			@RequestParam(name = "page") Integer page,
			@RequestParam(name = "elementPerPage") Integer elementPerPage,
			@RequestParam(name = "keywordsToSearch") String keywordsToSearch) {
		return employeeService.paginationEmployee(page, elementPerPage, keywordsToSearch);
	}
}
