package com.felipebs.moneyeasy.config.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.felipebs.moneyeasy.config.security.model.ERole;
import com.felipebs.moneyeasy.config.security.model.RoleModel;

@Repository
public interface IRoleRepository extends JpaRepository<RoleModel, Long> {
	
	Optional<RoleModel> findByName(ERole role);

}
