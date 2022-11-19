package com.felipebs.moneyeasy.config.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.felipebs.moneyeasy.config.security.model.UserModel;

@Repository
public interface IUserRepository extends JpaRepository<UserModel, Long> {

	@Query("FROM UserModel us WHERE us.username = :username")
	UserModel findByUsername(String username);

	boolean existsByUsername(String username);

}
