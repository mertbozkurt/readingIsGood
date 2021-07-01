package com.mertbozkurt.readingisgood.mapper;

import com.mertbozkurt.readingisgood.dto.book.BookDTO;
import com.mertbozkurt.readingisgood.dto.customer.CustomerProfileDTO;
import com.mertbozkurt.readingisgood.model.Book;
import com.mertbozkurt.readingisgood.model.Customer;
import com.mertbozkurt.readingisgood.model.Order;
import com.mertbozkurt.readingisgood.service.OrderService;
import org.apache.commons.collections4.CollectionUtils;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class BookDTOMapper {

    @Autowired
    private ModelMapper modelMapper;



    public Book convertBookDTOToBook(BookDTO bookDTO) {

        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
        Book book = modelMapper.map(bookDTO, Book.class);
        return book;
    }


}
