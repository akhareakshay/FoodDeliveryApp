package com.codewithakshay.fooddelivery.repository;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codewithakshay.fooddelivery.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

	public List<Users> findByUserId(Long userId);

	public List<Users> findByName(String name);

	public List<Users> findByEmail(String email);

	public List<Users> findByPassword(String password);

	public List<Users> findByPhone(Long phone);

	public List<Users> findByAddress(String address);

	public List<Users> findByNameAndEmail(String name, String email);

	public List<Users> findByEmailAndPassword(String email, String password);

	public List<Users> findByNameAndPhone(String name, Long phone);

	public List<Users> findByNameAndAddress(String name, String address);

	public List<Users> findByNameAndEmailAndPhone(String name, String email, String phone);

	public List<Users> findByNameAndEmailAndPasswordAndPhoneAndAddress(String name, String email, String password,
			Long phone, String address);
}
