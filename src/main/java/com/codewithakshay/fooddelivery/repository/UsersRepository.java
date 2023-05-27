package com.codewithakshay.fooddelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codewithakshay.fooddelivery.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

}
