package com.felipebs.moneyeasy.config.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.felipebs.moneyeasy.config.security.model.RefreshToken;
import com.felipebs.moneyeasy.config.security.model.UserModel;

@Repository
public interface IRefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

	Optional<RefreshToken> findByToken(String token);

	  @Modifying
	  int deleteByUser(UserModel userModel);

}
