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

import com.codewithakshay.fooddelivery.dto.TimeRange;

import lombok.Data;

@Entity
@Table(name = "restaurant")
@Data
public class Restaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long restaurantId;
	@NotBlank(message = "Name is Mandatory")
	private String name;
	@NotBlank(message = "Owner or Manager Name is Mandatory")
	@Column(name = "owner_manager")
	private String ownerOrManager;
	@NotNull(message = "Contact Number is Mandatory")
	@Column(name = "contact_number")
	private long contactNumber;
	@NotBlank(message = "Email is Mandatory")
	private String email;
	@NotBlank(message = "Address is Mandatory")
	private String address;
	@NotBlank(message = "Cuisine Type is Mandatory")
	@Column(name = "cuisine_type")
	private String cuisineType;
	@NotBlank(message = "Opening Hours are Mandatory")
	@Column(name = "opening_hours")
	private TimeRange openingHours;
	@NotNull(message = "Delivery Radius is Mandatory")
	@Column(name = "delivery_radius")
	private double deliveryRadius;
	@NotNull(message = "Minimum Order Amount is Mandatory")
	@Column(name = "minimum_order_amount")
	private double minimumOrderAmount;
	@Column(name = "average_rating")
	private double averageRating;
	@NotBlank(message = "Featured Image is Mandatory")
	@Column(name = "featured_image")
	private String featuredImage;
	@NotNull(message = "Menu Availability is Mandatory")
	@Column(name = "menu_availability")
	private boolean menuAvailability;
	@NotNull(message = "Active Statuss is Mandatory")
	@Column(name = "active_status")
	private boolean activeStatus;
	@Column(name = "update_date")
	private Timestamp updateDate;
	@UpdateTimestamp
	@Column(name = "creation_date")
	private Timestamp creationDate;

}
