package com.nitish.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nitish.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

	User findByUserId(Integer id);

	
}
