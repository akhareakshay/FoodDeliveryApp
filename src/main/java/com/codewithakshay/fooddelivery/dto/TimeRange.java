package com.codewithakshay.fooddelivery.dto;

import java.time.LocalTime;

import lombok.Data;

@Data
public class TimeRange {

	private LocalTime openingTime;
	private LocalTime closingTime;

}
