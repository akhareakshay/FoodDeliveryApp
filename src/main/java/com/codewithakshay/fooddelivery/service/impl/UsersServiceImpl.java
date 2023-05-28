package com.codewithakshay.fooddelivery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithakshay.fooddelivery.entity.Users;
import com.codewithakshay.fooddelivery.repository.UsersRepository;
import com.codewithakshay.fooddelivery.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersRepository usersRepository;

	@Override
	public Users setUsersData(Users users) {

		return null;
	}

	@Override
	public List<Users> searchUsers(Users users) {
		List<Users> usersList;
		if (users.getName() != null && users.getEmail() != null && users.getPassword() != null && users.getPhone() != 0
				&& users.getAddress() != null)
			usersList = usersRepository.findByNameAndEmailAndPasswordAndPhoneAndAddress(users.getName(),
					users.getEmail(), users.getPassword(), users.getPhone(), users.getAddress());
		else if (users.getName() != null && users.getAddress() != null)
			usersList = usersRepository.findByNameAndAddress(users.getName(), users.getAddress());
		else if (users.getName() != null && users.getPhone() != 0)
			usersList = usersRepository.findByNameAndPhone(users.getName(), users.getPhone());
		else if (users.getEmail() != null && users.getPassword() != null)
			usersList = usersRepository.findByEmailAndPassword(users.getEmail(), users.getPassword());
		else if (users.getName() != null && users.getEmail() != null)
			usersList = usersRepository.findByNameAndEmail(users.getName(), users.getEmail());
		else if (users.getAddress() != null)
			usersList = usersRepository.findByAddress(users.getAddress());
		else if (users.getPhone() != 0)
			usersList = usersRepository.findByPhone(users.getPhone());
		else if (users.getPassword() != null)
			usersList = usersRepository.findByPassword(users.getPassword());
		else if (users.getEmail() != null)
			usersList = usersRepository.findByPassword(users.getEmail());
		else if (users.getName() != null)
			usersList = usersRepository.findByName(users.getName());
		else
			usersList = usersRepository.findByUserId(users.getUserId());
		return usersList;
	}

}
