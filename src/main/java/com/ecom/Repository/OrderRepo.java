package com.ecom.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.Model.Order;

public interface OrderRepo extends JpaRepository<Order, Integer> {

}
