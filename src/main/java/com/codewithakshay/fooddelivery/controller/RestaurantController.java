package com.codewithakshay.fooddelivery.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithakshay.fooddelivery.entity.Restaurant;
import com.codewithakshay.fooddelivery.entity.Restaurant;
import com.codewithakshay.fooddelivery.entity.ValidList;
import com.codewithakshay.fooddelivery.repository.RestaurantRepository;
import com.codewithakshay.fooddelivery.util.FoodDeliveryErrorResponse;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/restaurant")
@Slf4j
public class RestaurantController {

	@Autowired
	private FoodDeliveryErrorResponse foodDeliveryErrorResponse;

	@Autowired
	private RestaurantRepository restaurantRepository;

	@PostMapping(value = "/saveorupdate", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> saveOrUpdateRestaurant(@Valid @RequestBody Restaurant restaurant,
			BindingResult bindingResult) {
		Restaurant restaurantData;
		try {
			if (bindingResult.hasErrors())
				return foodDeliveryErrorResponse.setValidationErrorResponse(bindingResult);
			restaurantData = restaurantRepository.save(restaurant);
			if (restaurantData != null)
				return new ResponseEntity<>(restaurantData, HttpStatus.OK);
			else
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			System.out.println("Exception : " + e);
			log.error("Exception while saving or updating restaurant ", e);
			return foodDeliveryErrorResponse.setExceptionResponse(e);
		}
	}

	@PostMapping(value = "/list/saveorupdate", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> saveOrUpdateListOfRestaurant(@Valid @RequestBody ValidList<Restaurant> restaurantList,
			BindingResult bindingResult) {
		List<Restaurant> restaurantDataList;
		try {
			if (bindingResult.hasErrors())
				return foodDeliveryErrorResponse.setValidationErrorResponse(bindingResult);
			restaurantDataList = restaurantRepository.saveAll(restaurantList.getList());
			if (!restaurantDataList.isEmpty())
				return new ResponseEntity<>(restaurantDataList, HttpStatus.OK);
			else
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			log.error("Exception while saving or updating list of Restaurant ", e);
			return foodDeliveryErrorResponse.setExceptionResponse(e);
		}
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getRestaurantList() {
		List<Restaurant> restaurantList;
		try {
			restaurantList = restaurantRepository.findAll();
			if (!restaurantList.isEmpty())
				return new ResponseEntity<>(restaurantList, HttpStatus.OK);
			else
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			log.error("Exception while getting list of Restaurant ", e);
			return foodDeliveryErrorResponse.setExceptionResponse(e);
		}
	}

	@PostMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> searchRestaurant(@RequestBody Restaurant restaurant) {
		List<Restaurant> restaurantDataList;
		try {
			restaurantDataList = restaurantService.searchRestaurant(restaurant);
			if (!restaurantDataList.isEmpty())
				return new ResponseEntity<>(RestaurantDataList, HttpStatus.OK);
			else
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			log.error("Exceptio while searching Restaurant ", e);
			return foodDeliveryErrorResponse.setExceptionResponse(e);
		}
	}

	@PostMapping("/delete")
	public ResponseEntity<Object> deleteRestaurantById(@RequestBody Restaurant restaurant) {
		try {
			restaurantRepository.deleteById(restaurant.getRestaurantId());
			return new ResponseEntity<>("Restaurant Deleted Successfully", HttpStatus.OK);
		} catch (Exception e) {
			log.error("Exception while deleting Restaurant ", e);
			return foodDeliveryErrorResponse.setExceptionResponse(e);
		}
	}

}
