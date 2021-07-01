package com.mertbozkurt.readingisgood.facade;

import com.mertbozkurt.readingisgood.dto.book.BookDTO;
import com.mertbozkurt.readingisgood.dto.customer.CustomerProfileDTO;
import com.mertbozkurt.readingisgood.mapper.BookDTOMapper;
import com.mertbozkurt.readingisgood.mapper.CustomerDTOMapper;
import com.mertbozkurt.readingisgood.service.BookService;
import com.mertbozkurt.readingisgood.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookFacade {

    @Autowired
    private BookDTOMapper bookDTOMapper;

    @Autowired
    BookService bookService;

    public void createBook(BookDTO bookDTO) {
        bookService.createBook(bookDTOMapper.convertBookDTOToBook(bookDTO));
    }
}
