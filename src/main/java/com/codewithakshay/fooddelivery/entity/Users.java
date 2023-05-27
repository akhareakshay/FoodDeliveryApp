package com.codewithakshay.fooddelivery.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	@NotEmpty(message = "user name should not be empty")
	private String name;
	@NotEmpty(message = "user email should not be empty")
	private String Email;
	@NotEmpty(message = "user password should not be empty")
	private String Password;
	@NotEmpty(message = "user phone should not be empty")
	private long Phone;
	@NotEmpty(message = "user address should not be empty")
	private String Address;
	@Column(name = "registration_data")
	private Timestamp RegistrationDate;
	@Column(name = "last_login")
	private Timestamp LastLogin;

}
