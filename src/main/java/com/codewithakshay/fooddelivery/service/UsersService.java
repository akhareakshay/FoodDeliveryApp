package com.codewithakshay.fooddelivery.service;

import java.util.List;

import com.codewithakshay.fooddelivery.entity.Users;

public interface UsersService {

	public Users setUsersData(Users users);

	public List<Users> searchUsers(Users users);

}
