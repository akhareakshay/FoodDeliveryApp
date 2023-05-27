package com.codewithakshay.fooddelivery.entity;

import java.util.List;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import lombok.Data;

@Data
@Validated
public class ValidList<E> {

	@Valid
	private List<E> list;
	
}
