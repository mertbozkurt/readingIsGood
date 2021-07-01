package com.mertbozkurt.readingisgood.mapper;

import com.mertbozkurt.readingisgood.dto.customer.CustomerProfileDTO;
import com.mertbozkurt.readingisgood.model.Customer;
import org.modelmapper.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerDTOMapper {

    @Autowired
    private ModelMapper modelMapper;


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
}
