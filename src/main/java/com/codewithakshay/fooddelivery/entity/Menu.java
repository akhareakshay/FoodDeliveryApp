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
	private String name;
	private String description;
	private double price;
	private String image;
	private String category;
	@Column(name = "creation_date")
	private Timestamp creationDate;
	@Column(name = "update_date")
	private Timestamp updateDate;

}
