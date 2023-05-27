package com.codewithakshay.fooddelivery.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	@NotBlank(message = "Name is Mandatory")
	private String name;
	@NotBlank(message = "Email is Mandatory")
	private String email;
	@NotBlank(message = "Password is Mandatory")
	private String password;
	@NotNull(message = "Phone is Mandatory")
	private long phone;
	@NotBlank(message = "Address is Mandatory")
	private String address;
	@Column(name = "last_login")
	private Timestamp lastLogin;
	@UpdateTimestamp
	@Column(name = "registration_date")
	private Timestamp registrationDate;

}
