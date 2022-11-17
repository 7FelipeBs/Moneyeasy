package com.felipebs.moneyeasy.repository;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.felipebs.moneyeasy.models.Employee;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {

	@Query("FROM Employee em"
			+ "	WHERE em.name LIKE :keywordsToSearch")
	Employee paginationEmployee(String keywordsToSearch, PageRequest of);

}
