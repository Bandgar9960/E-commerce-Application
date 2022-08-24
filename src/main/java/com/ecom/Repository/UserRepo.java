package com.ecom.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.Model.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	public User findByEmail(String email);

}
