package com.mertbozkurt.readingisgood.controller;

import com.mertbozkurt.readingisgood.dto.book.BookDTO;
import com.mertbozkurt.readingisgood.dto.customer.CustomerProfileDTO;
import com.mertbozkurt.readingisgood.dto.customer.CustomerProfilesDTO;
import com.mertbozkurt.readingisgood.facade.BookFacade;
import com.mertbozkurt.readingisgood.facade.CustomerFacade;
import com.mertbozkurt.readingisgood.facade.StockFacade;
import com.nimbusds.oauth2.sdk.util.CollectionUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/book")
public class BookController {

    @Autowired
    private BookFacade bookFacade;
    private StockFacade stockFacade;


    @PostMapping
    public ResponseEntity createBook(@RequestBody BookDTO bookDTO) {

        try {
            bookFacade.createBook(bookDTO);
            return ResponseEntity.ok(bookDTO);

        } catch (HttpClientErrorException.BadRequest exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("New Book could not be created");
        }

    }

    @PostMapping("/{bookId}/{stock}")
    public ResponseEntity updateBookStock(@PathVariable("stock") int stock, @PathVariable("bookId") long bookId) {

        try {
            return ResponseEntity.ok(stockFacade.updateBookStock(bookId, stock));

        } catch (HttpClientErrorException.BadRequest exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Stock could not be updated");
        }

    }


}
