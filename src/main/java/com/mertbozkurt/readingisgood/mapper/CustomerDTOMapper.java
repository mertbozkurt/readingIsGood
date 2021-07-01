package com.mertbozkurt.readingisgood.mapper;

import com.mertbozkurt.readingisgood.dto.customer.CustomerProfileDTO;
import com.mertbozkurt.readingisgood.model.Customer;
import com.mertbozkurt.readingisgood.model.Order;
import com.mertbozkurt.readingisgood.service.OrderService;
import org.modelmapper.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CustomerDTOMapper {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    OrderService orderService;


    public Customer convertCustomerProfileDTOToCustomer(CustomerProfileDTO customerProfileDTO) {

        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
        Customer customer = modelMapper.map(customerProfileDTO, Customer.class);
        return customer;
    }

    public List<CustomerProfileDTO> convertModelToCustomerProfileDTOList(List<Customer> customerList) {
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
        List<CustomerProfileDTO> customerProfileDTOList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(customerList)) {
            customerList.stream().forEach(x -> {
                CustomerProfileDTO customerProfileDTO = modelMapper.map(x, CustomerProfileDTO.class);
                customerProfileDTOList.add(customerProfileDTO);

            });
        }
        return customerProfileDTOList;

    }

    public CustomerProfileDTO convertModelToCustomerProfileDTO(Optional<Customer> customer) {
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);

        CustomerProfileDTO customerProfileDTO = modelMapper.map(customer, CustomerProfileDTO.class);
        List<Order> orderList = orderService.getCustomerOrders(customer.get().getId());
        customerProfileDTO.setOrders(orderList);

        return customerProfileDTO;
    }
}
