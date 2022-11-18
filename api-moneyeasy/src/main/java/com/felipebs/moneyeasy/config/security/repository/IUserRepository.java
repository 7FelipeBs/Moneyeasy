package com.felipebs.moneyeasy.config.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.felipebs.moneyeasy.config.security.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

	@Query("FROM User us WHERE us.username = :username")
	User findByUsername(String username);

}
