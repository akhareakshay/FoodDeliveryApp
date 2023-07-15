package com.codewithakshay.fooddelivery.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Table(name = "menu")
@Data
public class Menu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long menuId;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "restaurant_id")
	private Restaurant restaurant;
	@NotBlank(message = "Name is Mandatory")
	private String name;
	@NotBlank(message = "Description is Mandatory")
	private String description;
	@NotNull(message = "Price is Mandatory")
	private double price;
	private String image;
	@NotBlank(message = "Category is Mandatory")
	private String category;
	@UpdateTimestamp
	@Column(name = "creation_date")
	private Timestamp creationDate;
	@Column(name = "update_date")
	private Timestamp updateDate;

}
