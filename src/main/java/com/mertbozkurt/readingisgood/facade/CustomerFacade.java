package com.mertbozkurt.readingisgood.facade;

import com.mertbozkurt.readingisgood.dto.customer.CustomerProfileDTO;
import com.mertbozkurt.readingisgood.mapper.CustomerDTOMapper;
import com.mertbozkurt.readingisgood.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerFacade {


    @Autowired
    private CustomerDTOMapper customerDTOMapper;

    @Autowired
    CustomerService customerService;

    public List<CustomerProfileDTO> getCustomerProfiles(LocalDateTime updateDate){

        List<CustomerProfileDTO> testList = new ArrayList<>();



        //return testList;
        return customerDTOMapper.convertModelToCustomerProfileDTOList(customerService.getCustomerList());
    }

    public void addCustomer(CustomerProfileDTO customerProfileDTO) {

        customerService.addCustomer(customerDTOMapper.convertCustomerProfileDTOToCustomer(customerProfileDTO));
    }
}
