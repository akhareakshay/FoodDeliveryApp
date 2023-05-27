package com.codewithakshay.fooddelivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FoodDeliveryAppApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(FoodDeliveryAppApplication.class, args);
		} catch (Exception e) {
			System.out.println("exception occured : " + e);
		}
	}

}
