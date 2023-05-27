package com.codewithakshay.fooddelivery.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	
	private String name;
	private String Email;
	private String Password;
	private long Phone;
	private String Address;
	@Column(name = "registration_data")
	private Timestamp RegistrationDate;
	@Column(name = "last_login")
	private Timestamp LastLogin;

}
