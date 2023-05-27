package com.codewithakshay.fooddelivery.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithakshay.fooddelivery.entity.Users;
import com.codewithakshay.fooddelivery.repository.UsersRepository;

@RestController
@RequestMapping("/users")
public class UsersController {

	@Autowired
	private UsersRepository usersRepository;

	@PostMapping(value = "/saveorupdate", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> saveOrUpdateUser(@Valid @RequestBody Users users, BindingResult bindingResult) {
		try {
			if (bindingResult.hasErrors())
				return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
			Users usersData = usersRepository.save(users);
			if (usersData != null)
				return new ResponseEntity<>(usersData, HttpStatus.OK);
			else
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>("Exception while saving or updating user", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
