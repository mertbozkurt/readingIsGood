package com.mertbozkurt.readingisgood.service;

import com.mertbozkurt.readingisgood.model.Order;
import com.mertbozkurt.readingisgood.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class OrderService {

    @Autowired(required = false)
    OrderRepository orderRepository;

    public List<Order> getCustomerOrders(long customerId) {
        return orderRepository.findAllByCustomerId(customerId);
    }

    public Order createOrder(Order order) {

        order.setOrderDate(LocalDateTime.now());
        return orderRepository.save(order);
    }

    public Order getOrder(long orderId) {
        return orderRepository.getById(orderId);
    }
}
