package com.cemal.librarymanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cemal.librarymanagementsystem.entity.User;



public interface UserRepository extends JpaRepository<User, Long>{
	
	   User findByUsername(String username);

}
