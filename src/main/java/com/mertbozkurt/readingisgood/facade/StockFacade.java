package com.mertbozkurt.readingisgood.facade;

import com.mertbozkurt.readingisgood.mapper.StockDTOMapper;
import com.mertbozkurt.readingisgood.model.Stock;
import com.mertbozkurt.readingisgood.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class StockFacade {

    @Autowired
    private StockDTOMapper stockDTOMapper;

    @Autowired
    StockService stockService;

    public Stock updateBookStock(long bookId, int stock) {
        return stockService.updateStock(bookId,stock);
    }
}
