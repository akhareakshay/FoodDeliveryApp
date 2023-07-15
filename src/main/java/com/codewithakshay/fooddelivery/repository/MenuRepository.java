package com.codewithakshay.fooddelivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codewithakshay.fooddelivery.entity.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

	public List<Menu> findByMenuId(Long menuId);

	public List<Menu> findByName(String name);

	public List<Menu> findByDescription(String description);

	public List<Menu> findByPrice(double price);

	public List<Menu> findByImage(String image);

	public List<Menu> findByCategory(String category);

	public List<Menu> findByNameAndDescription(String name, String description);

	public List<Menu> findByNameAndPrice(String name, double price);

	public List<Menu> findByNameAndImage(String name, String image);

	public List<Menu> findByNameAndCategory(String name, String category);

	public List<Menu> findByNameAndDescriptionAndPrice(String name, String description, double price);

	public List<Menu> findByPriceAndCategory(double price, String category);

}
