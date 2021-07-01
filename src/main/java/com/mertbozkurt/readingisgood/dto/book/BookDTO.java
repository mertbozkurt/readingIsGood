package com.mertbozkurt.readingisgood.dto.book;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mertbozkurt.readingisgood.model.Order;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;


@Getter
@Setter
@JsonInclude(JsonInclude.Include.ALWAYS)
public class BookDTO {

    private long id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("auther")
    private String auther;

    @JsonProperty("year")
    private int year;

    @JsonProperty("publisher")
    public String publisher;

    @JsonProperty("price")
    public double price;

}
