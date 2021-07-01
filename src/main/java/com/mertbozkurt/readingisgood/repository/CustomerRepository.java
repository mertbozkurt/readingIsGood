package com.mertbozkurt.readingisgood.repository;

import com.mertbozkurt.readingisgood.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
