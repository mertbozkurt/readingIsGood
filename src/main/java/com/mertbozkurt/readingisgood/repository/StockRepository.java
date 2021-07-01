package com.mertbozkurt.readingisgood.repository;


import com.mertbozkurt.readingisgood.model.Order;
import com.mertbozkurt.readingisgood.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface StockRepository extends JpaRepository<Stock,Long> {

    Stock  findByBookId(long bookId);

}
