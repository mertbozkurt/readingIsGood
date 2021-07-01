package com.mertbozkurt.readingisgood.service;

import com.mertbozkurt.readingisgood.model.Customer;
import com.mertbozkurt.readingisgood.model.Order;
import com.mertbozkurt.readingisgood.repository.CustomerRepository;
import com.mertbozkurt.readingisgood.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CustomerService {


    @Autowired(required = false)
    CustomerRepository customerRepository;




    public Customer addCustomer(Customer customer){

        customerRepository.save(customer);
        return customer;
    }

    public List<Customer> getCustomerList() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerInformation(long customerId) {

        return customerRepository.findById(customerId);
    }


}
