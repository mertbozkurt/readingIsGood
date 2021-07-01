package com.mertbozkurt.readingisgood.dto.customer;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonInclude(JsonInclude.Include.ALWAYS)
@Getter
@Setter
public class CustomerProfilesDTO {

    @JsonProperty("profiles")
    private List<CustomerProfileDTO> customerProfiles;


    @JsonProperty("count")
    private int count;
}
