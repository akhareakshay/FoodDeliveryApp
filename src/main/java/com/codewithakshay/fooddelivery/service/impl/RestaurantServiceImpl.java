package com.codewithakshay.fooddelivery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithakshay.fooddelivery.entity.Restaurant;
import com.codewithakshay.fooddelivery.repository.RestaurantRepository;
import com.codewithakshay.fooddelivery.service.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private RestaurantRepository restaurantRepository;

	@Override
	public List<Restaurant> searchRestaurant(Restaurant restaurant) {
		List<Restaurant> restaurantData;
		if (restaurant.getName() != null) {
			if (restaurant.getOwnerManager() != null) {
				restaurantData = restaurantRepository.findByNameAndOwnerManager(restaurant.getName(),
						restaurant.getOwnerManager());
			} else if (restaurant.getCuisineType() != null)
				restaurantData = restaurantRepository.findByNameAndCuisineType(restaurant.getName(),
						restaurant.getCuisineType());
			else if (restaurant.getOpeningHours() != null && restaurant.getDeliveryRadius() != 0.0)
				restaurantData = restaurantRepository.findByNameAndOpeningHoursAndDeliveryRadius(restaurant.getName(),
						restaurant.getOpeningHours(), restaurant.getDeliveryRadius());
			else if (restaurant.getOpeningHours() != null)
				restaurantData = restaurantRepository.findByNameAndOpeningHours(restaurant.getName(),
						restaurant.getOpeningHours());
			else if (restaurant.getMinimumOrderAmount() != 0.0)
				restaurantData = restaurantRepository.findByNameAndMinimumOrderAmount(restaurant.getName(),
						restaurant.getMinimumOrderAmount());
			else if (restaurant.getAverageRating() != 0.0)
				restaurantData = restaurantRepository.findByNameAndAverageRating(restaurant.getName(),
						restaurant.getAverageRating());
			else if (restaurant.isMenuAvailability() == true || restaurant.isMenuAvailability() == false)
				restaurantData = restaurantRepository.findByNameAndMenuAvailability(restaurant.getName(),
						restaurant.isMenuAvailability());
			else if (restaurant.isActiveStatus() == true || restaurant.isActiveStatus() == false)
				restaurantData = restaurantRepository.findByNameAndActiveStatus(restaurant.getName(),
						restaurant.isActiveStatus());
			else
				restaurantData = restaurantRepository.findByName(restaurant.getName());
		} else {
			if (restaurant.getAddress() != null)
				restaurantData = restaurantRepository.findByAddress(restaurant.getAddress());
			else if (restaurant.getAverageRating() != 0.0)
				restaurantData = restaurantRepository.findByAverageRating(restaurant.getAverageRating());
			else if (restaurant.getContactNumber() != null)
				restaurantData = restaurantRepository.findByContactNumber(restaurant.getContactNumber());
			else if (restaurant.getCuisineType() != null)
				restaurantData = restaurantRepository.findByCuisineType(restaurant.getCuisineType());
			else if (restaurant.getDeliveryRadius() != 0.0)
				restaurantData = restaurantRepository.findByDeliveryRadius(restaurant.getDeliveryRadius());
			else if (restaurant.getEmail() != null)
				restaurantData = restaurantRepository.findByEmail(restaurant.getEmail());
			else if (restaurant.getMinimumOrderAmount() != 0.0)
				restaurantData = restaurantRepository.findByMinimumOrderAmount(restaurant.getMinimumOrderAmount());
			else if (restaurant.getOpeningHours() != null)
				restaurantData = restaurantRepository.findByOpeningHours(restaurant.getOpeningHours());
			else if (restaurant.getOwnerManager() != null)
				restaurantData = restaurantRepository.findByOwnerManager(restaurant.getOwnerManager());
			else if (restaurant.isActiveStatus() == true || restaurant.isActiveStatus() == false)
				restaurantData = restaurantRepository.findByActiveStatus(restaurant.isActiveStatus());
			else if (restaurant.isMenuAvailability() == true || restaurant.isMenuAvailability() == false)
				restaurantData = restaurantRepository.findByMenuAvailability(restaurant.isMenuAvailability());
			else
				restaurantData = restaurantRepository.findByRestaurantId(restaurant.getRestaurantId());
		}
		return restaurantData;
	}

}
