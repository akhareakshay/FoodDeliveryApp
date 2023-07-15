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

import com.codewithakshay.fooddelivery.entity.Menu;
import com.codewithakshay.fooddelivery.entity.ValidList;
import com.codewithakshay.fooddelivery.repository.MenuRepository;
import com.codewithakshay.fooddelivery.service.MenuService;
import com.codewithakshay.fooddelivery.util.FoodDeliveryErrorResponse;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("menu")
@Slf4j
public class MenuController {

	@Autowired
	private FoodDeliveryErrorResponse foodDeliveryErrorResponse;

	@Autowired
	private MenuRepository menuRepository;

	@Autowired
	private MenuService menuService;

	@PostMapping(value = "/saveorupdate", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> saveOrUpdateMenu(@Valid @RequestBody Menu menu, BindingResult bindingResult) {
		Menu menuData;
		try {
			if (bindingResult.hasErrors())
				return foodDeliveryErrorResponse.setValidationErrorResponse(bindingResult);
			menuData = menuRepository.save(menu);
			if (menuData != null)
				return new ResponseEntity<>(menuData, HttpStatus.OK);
			else
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			log.error("Exception while saving or updating Menu ", e);
			return foodDeliveryErrorResponse.setExceptionResponse(e);
		}
	}

	@PostMapping(value = "/list/saveorupdate", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> saveOrUpdateListOfMenu(@Valid @RequestBody ValidList<Menu> menuList,
			BindingResult bindingResult) {
		List<Menu> menuDataList;
		try {
			if (bindingResult.hasErrors())
				return foodDeliveryErrorResponse.setValidationErrorResponse(bindingResult);
			menuDataList = menuRepository.saveAll(menuList.getList());
			if (!menuDataList.isEmpty())
				return new ResponseEntity<>(menuDataList, HttpStatus.OK);
			else
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			log.error("Exception while saving or updating list of Menu ", e);
			return foodDeliveryErrorResponse.setExceptionResponse(e);
		}
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getMenuList() {
		List<Menu> menuList;
		try {
			menuList = menuRepository.findAll();
			if (!menuList.isEmpty())
				return new ResponseEntity<>(menuList, HttpStatus.OK);
			else
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			log.error("Exception while getting list of Menu ", e);
			return foodDeliveryErrorResponse.setExceptionResponse(e);
		}
	}

	@PostMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> searchMenu(@RequestBody Menu menu) {
		List<Menu> menuDataList;
		try {
			menuDataList = menuService.searchMenu(menu);
			if (!menuDataList.isEmpty())
				return new ResponseEntity<>(menuDataList, HttpStatus.OK);
			else
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			log.error("Exception while searching Menu ", e);
			return foodDeliveryErrorResponse.setExceptionResponse(e);
		}
	}

	@PostMapping("/delete")
	public ResponseEntity<Object> deleteMenuById(@RequestBody Menu menu) {
		try {
			menuRepository.deleteById(menu.getMenuId());
			return new ResponseEntity<>("Menu Deleted Successfully", HttpStatus.OK);
		} catch (Exception e) {
			log.error("Exception while deleting Menu ", e);
			return foodDeliveryErrorResponse.setExceptionResponse(e);
		}
	}

}
