package com.mertbozkurt.readingisgood.dto.customer;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.jackson.JsonComponent;


@Getter
@Setter
@JsonInclude(JsonInclude.Include.ALWAYS)
public class CustomerProfileDTO {

    private long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("email_address")
    private String emailAddress;

    @JsonProperty("phone_number")
    private String phoneNumber;

}
