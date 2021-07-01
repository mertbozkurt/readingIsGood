package com.mertbozkurt.readingisgood.facade;

import com.mertbozkurt.readingisgood.dto.customer.CustomerProfileDTO;
import com.mertbozkurt.readingisgood.mapper.CustomerDTOMapper;
import com.mertbozkurt.readingisgood.model.Customer;
import com.mertbozkurt.readingisgood.model.Order;
import com.mertbozkurt.readingisgood.service.CustomerService;
import com.mertbozkurt.readingisgood.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CustomerFacade {


    @Autowired
    private CustomerDTOMapper customerDTOMapper;

    @Autowired
    CustomerService customerService;

    public List<CustomerProfileDTO> getCustomerProfiles() {

        return customerDTOMapper.convertModelToCustomerProfileDTOList(customerService.getCustomerList());
    }

    public void addCustomer(CustomerProfileDTO customerProfileDTO) {
        customerService.addCustomer(customerDTOMapper.convertCustomerProfileDTOToCustomer(customerProfileDTO));
    }

    public CustomerProfileDTO getCustomerInformation(long customerId) {
        Optional<Customer> customer = customerService.getCustomerInformation(customerId);
        return customerDTOMapper.convertModelToCustomerProfileDTO(customer);
    }
}
