package com.mertbozkurt.readingisgood.mapper;

import com.mertbozkurt.readingisgood.dto.Order.OrderDTO;
import com.mertbozkurt.readingisgood.dto.book.BookDTO;
import com.mertbozkurt.readingisgood.model.Book;
import com.mertbozkurt.readingisgood.model.Order;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderDTOMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Order convertOrderDTOToOrder(OrderDTO orderDTO) {

        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
        Order order = modelMapper.map(orderDTO, Order.class);
        return order;
    }


    public OrderDTO convertModelToOrderDTO(Order order) {
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
        OrderDTO orderDTO = modelMapper.map(order, OrderDTO.class);
        return orderDTO;

    }
}
