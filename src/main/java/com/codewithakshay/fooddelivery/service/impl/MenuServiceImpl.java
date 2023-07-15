package com.codewithakshay.fooddelivery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithakshay.fooddelivery.entity.Menu;
import com.codewithakshay.fooddelivery.repository.MenuRepository;
import com.codewithakshay.fooddelivery.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuRepository menuRepository;

	@Override
	public List<Menu> searchMenu(Menu menu) {
		List<Menu> menuData;
		if (menu.getName() != null) {
			if (menu.getCategory() != null && menu.getPrice() != 0.0)
				menuData = menuRepository.findByPriceAndCategory(menu.getPrice(), menu.getCategory());
			else if (menu.getCategory() != null)
				menuData = menuRepository.findByNameAndCategory(menu.getName(), menu.getCategory());
			else if (menu.getDescription() != null)
				menuData = menuRepository.findByNameAndDescription(menu.getName(), menu.getDescription());
			else if (menu.getPrice() != 0.0)
				menuData = menuRepository.findByNameAndPrice(menu.getName(), menu.getPrice());
			else if (menu.getImage() != null)
				menuData = menuRepository.findByNameAndImage(menu.getName(), menu.getImage());
			else
				menuData = menuRepository.findByName(menu.getName());

		} else {
			if (menu.getCategory() != null)
				menuData = menuRepository.findByCategory(menu.getCategory());
			else if (menu.getDescription() != null)
				menuData = menuRepository.findByDescription(menu.getDescription());
			else if (menu.getImage() != null)
				menuData = menuRepository.findByImage(menu.getImage());
			else if (menu.getPrice() != 0.0)
				menuData = menuRepository.findByPrice(menu.getPrice());
			else
				menuData = menuRepository.findByMenuId(menu.getMenuId());
		}
		return menuData;
	}

}
