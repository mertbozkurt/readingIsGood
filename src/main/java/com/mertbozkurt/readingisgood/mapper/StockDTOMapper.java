package com.mertbozkurt.readingisgood.mapper;

import com.mertbozkurt.readingisgood.dto.book.BookDTO;
import com.mertbozkurt.readingisgood.dto.stock.StockDTO;
import com.mertbozkurt.readingisgood.model.Book;
import com.mertbozkurt.readingisgood.model.Stock;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StockDTOMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Stock convertStockDTOToStock(StockDTO stockDTO) {

        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
        Stock stock= modelMapper.map(stockDTO, Stock.class);
        return stock;
    }


}
