package com.mertbozkurt.readingisgood.service;

import com.mertbozkurt.readingisgood.model.Book;
import com.mertbozkurt.readingisgood.model.Stock;
import com.mertbozkurt.readingisgood.repository.BookRepository;
import com.mertbozkurt.readingisgood.repository.StockRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class StockService {

    @Autowired(required = false)
    StockRepository stockRepository;


    public Stock updateStock(long bookId, int value) {

        Stock stock =stockRepository.findByBookId(bookId);
        if (stock!=null) {
            stock.setStock(value);
        }else{
            stock.setBookId(bookId);
            stock.setStock(value);
        }

        return stockRepository.save(stock);

    }

    public Stock decreaseStock(long bookId) {

        Stock stock =stockRepository.findByBookId(bookId);
        if (stock!=null) {
            stock.setStock(stock.getStock()-1);
        }

        return stockRepository.save(stock);

    }

    public Stock getStock(long bookId) {
        return stockRepository.findByBookId(bookId);

    }

}
