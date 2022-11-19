package com.felipebs.moneyeasy.dtos.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtResponse {

	private String token;
	private String type = "Bearer";
	private String refreshToken;
	private Long id;
	private String username;
	private List<String> roles;
	
	
	public JwtResponse(String accessToken, String refreshToken, Long id, String username, List<String> roles) {
		this.token = accessToken;
		this.refreshToken = refreshToken;
		this.id = id;
		this.username = username;
		this.roles = roles;
	}

}
