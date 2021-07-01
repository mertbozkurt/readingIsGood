package com.mertbozkurt.readingisgood.controller;

import com.mertbozkurt.readingisgood.dto.Order.OrderDTO;
import com.mertbozkurt.readingisgood.dto.book.BookDTO;
import com.mertbozkurt.readingisgood.dto.customer.CustomerProfileDTO;
import com.mertbozkurt.readingisgood.facade.BookFacade;
import com.mertbozkurt.readingisgood.facade.OrderFacade;
import com.mertbozkurt.readingisgood.facade.StockFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@Slf4j
@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    @Autowired
    private OrderFacade orderFacade;

    @PostMapping
    public ResponseEntity createOrder(@RequestBody OrderDTO orderDTO) {

        try {
            return ResponseEntity.ok(orderFacade.createOrder(orderDTO));

        } catch (HttpClientErrorException.BadRequest exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("New Order could not be created");
        }
    }

    @GetMapping("/{orderId}")
    public ResponseEntity getOrder(@PathVariable("orderId") long orderId) {
        try {

            OrderDTO orderDTO = orderFacade.getOrder(orderId);
            return ResponseEntity.ok(orderDTO);

        } catch (HttpClientErrorException.NotFound exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("There is no order with an ID" + orderId );
        }

    }




}
