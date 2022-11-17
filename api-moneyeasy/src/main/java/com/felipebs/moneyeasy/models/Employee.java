package com.felipebs.moneyeasy.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.felipebs.moneyeasy.enums.ERoleEmployee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EMPLOYEE")
public class Employee implements Serializable{
	private static final long serialVersionUID = 161120221955L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_EMPLOYEE")
	private Long idEmployee;
	
	@Column(name = "NAME_EMPLOYEE")
	private String name;
	
	@Column(name = "LAST_NAME_EMPLOYEE")
	private String lastName;
	
	@Column(name = "BIRTH_DATE")
	private LocalDate birthDate;
	
	@Column(name = "ROLE_EMPLOYEE")
	@Enumerated(EnumType.STRING)
	private ERoleEmployee eRoleEmployee;
	
	@Column(name = "SALARY")
	private BigDecimal salary;

}
