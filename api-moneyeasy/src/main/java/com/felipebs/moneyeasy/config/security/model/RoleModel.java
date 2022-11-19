package com.felipebs.moneyeasy.config.security.model;

import java.io.Serializable;

import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ROLES")
public class RoleModel implements Serializable, GrantedAuthority {
	private static final long serialVersionUID = 191120220830L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ROLE_ID")
	private Integer id;

	@Enumerated(EnumType.STRING)
	@Column(name = "ROLES_NAME")
	private ERole name;

	@Override
	public String getAuthority() {
		return this.name.toString();
	}

}