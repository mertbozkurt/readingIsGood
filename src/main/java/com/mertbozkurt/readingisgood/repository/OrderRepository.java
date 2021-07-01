package com.mertbozkurt.readingisgood.repository;


import com.mertbozkurt.readingisgood.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface OrderRepository extends JpaRepository<Order,Long> {

    List<Order> findAllByCustomerId(long customerId);
}
