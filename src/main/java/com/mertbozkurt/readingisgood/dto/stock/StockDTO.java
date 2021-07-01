package com.mertbozkurt.readingisgood.dto.stock;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Getter
@Setter
@JsonInclude(JsonInclude.Include.ALWAYS)
public class StockDTO {

    private long id;

    @JsonProperty("book_id")
    private long bookId;

    @JsonProperty("stock")
    private int stock;

}
