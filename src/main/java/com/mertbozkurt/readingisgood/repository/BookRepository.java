package com.mertbozkurt.readingisgood.repository;


import com.mertbozkurt.readingisgood.model.Book;
import com.mertbozkurt.readingisgood.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BookRepository extends JpaRepository<Book,Long> {

}
