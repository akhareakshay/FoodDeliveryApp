package com.codewithakshay.fooddelivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codewithakshay.fooddelivery.dto.TimeRange;
import com.codewithakshay.fooddelivery.entity.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

	public List<Restaurant> findByRestaurantId(Long restaurantId);

	public List<Restaurant> findByName(String name);

	public List<Restaurant> findByOwnerManager(String ownerManager);

	public List<Restaurant> findByContactNumber(String contactNumber);

	public List<Restaurant> findByEmail(String email);

	public List<Restaurant> findByAddress(String address);

	public List<Restaurant> findByCuisineType(String cuisineType);

	public List<Restaurant> findByOpeningHours(String openingHours);

	public List<Restaurant> findByDeliveryRadius(double deliveryRadius);

	public List<Restaurant> findByMinimumOrderAmount(double minimumOrderAmount);

	public List<Restaurant> findByAverageRating(double averageRating);

	public List<Restaurant> findByMenuAvailability(boolean menuAvailability);

	public List<Restaurant> findByActiveStatus(boolean activeStatus);

	public List<Restaurant> findByNameAndOwnerManager(String name, String ownerManager);

	public List<Restaurant> findByContactNumberAndEmail(String contactNumber, String email);

	public List<Restaurant> findByContactNumberAndEmailAndAddress(String contactNumber, String email, String address);

	public List<Restaurant> findByNameAndCuisineType(String name, String cuisineType);

	public List<Restaurant> findByNameAndOpeningHours(String name, String openingHours);

	public List<Restaurant> findByNameAndOpeningHoursAndDeliveryRadius(String name, String openingHours,
			double deliveryRadius);

	public List<Restaurant> findByNameAndMinimumOrderAmount(String name, double minimumOrderAmount);

	public List<Restaurant> findByNameAndAverageRating(String name, double averageRating);

	public List<Restaurant> findByNameAndMenuAvailability(String name, boolean menuAvailability);

	public List<Restaurant> findByNameAndActiveStatus(String name, boolean activeStatus);
}
