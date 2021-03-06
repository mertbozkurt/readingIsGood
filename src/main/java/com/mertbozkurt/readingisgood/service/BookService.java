package com.mertbozkurt.readingisgood.service;

import com.mertbozkurt.readingisgood.model.Book;
import com.mertbozkurt.readingisgood.model.Order;
import com.mertbozkurt.readingisgood.repository.BookRepository;
import com.mertbozkurt.readingisgood.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BookService {

    @Autowired(required = false)
    BookRepository bookRepository;

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }
}
