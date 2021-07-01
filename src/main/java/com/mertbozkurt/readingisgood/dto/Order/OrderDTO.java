package com.mertbozkurt.readingisgood.dto.Order;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@JsonInclude(JsonInclude.Include.ALWAYS)
public class OrderDTO {

    private long id;

    @JsonProperty("customer_id")
    private Long customerId;

    @JsonProperty("book_ids")
    private List<Long> bookIds;

    @JsonProperty("status")
    private String status;

    @JsonProperty("order_date")
    private LocalDateTime orderDate;
}
