package com.ecom.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.Model.Cart;
import com.ecom.Model.User;

public interface CartRepo extends JpaRepository<Cart, Integer> {
	
	Optional<Cart> findByUser(User user);

}
