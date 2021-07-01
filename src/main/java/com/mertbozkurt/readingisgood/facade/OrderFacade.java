package com.mertbozkurt.readingisgood.facade;

import com.mertbozkurt.readingisgood.dto.Order.OrderDTO;
import com.mertbozkurt.readingisgood.mapper.OrderDTOMapper;
import com.mertbozkurt.readingisgood.model.Order;
import com.mertbozkurt.readingisgood.service.OrderService;
import com.mertbozkurt.readingisgood.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicBoolean;

@Component
public class OrderFacade {

    @Autowired
    private OrderDTOMapper orderDTOMapper;

    @Autowired
    OrderService orderService;
    StockService stockService;

    public OrderDTO createOrder(OrderDTO orderDTO) {
        AtomicBoolean stockAvailable = new AtomicBoolean(true);
        orderDTO.getBookIds().stream().forEach(x-> {
            if(stockService.getStock(x).getStock()==0){
                stockAvailable.set(false);
            }
        } );
        if(stockAvailable.get() == true){
            orderService.createOrder(orderDTOMapper.convertOrderDTOToOrder(orderDTO));
            orderDTO.getBookIds().stream().forEach(x->{
                stockService.decreaseStock(x);
            });
        }
        return orderDTO;
    }

    public OrderDTO getOrder(long orderId) {

        return orderDTOMapper.convertModelToOrderDTO(orderService.getOrder(orderId));

    }
}
