package com.mertbozkurt.readingisgood.controller;

import com.mertbozkurt.readingisgood.dto.customer.CustomerProfileDTO;
import com.mertbozkurt.readingisgood.dto.customer.CustomerProfilesDTO;
import com.mertbozkurt.readingisgood.facade.CustomerFacade;
import com.nimbusds.oauth2.sdk.util.CollectionUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerFacade customerFacade;

    public static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SS");

    @GetMapping("/profiles")
    public ResponseEntity getAllCustomerProfiles(@RequestParam(value = "offset", required = false, defaultValue = "0") int offset,
                                                 @RequestParam(value = "limit", required = false, defaultValue = "100") int limit) {

        try {
            CustomerProfilesDTO customerProfilesDTO = new CustomerProfilesDTO();
            List<CustomerProfileDTO> customerProfileDTOList = customerFacade.getCustomerProfiles();
            if (CollectionUtils.isNotEmpty(customerProfileDTOList)) {
                if (offset < customerProfileDTOList.size()) {
                    int upperBound = offset + limit;
                    upperBound = upperBound >= customerProfileDTOList.size() ? customerProfileDTOList.size()
                            : upperBound;
                    customerProfilesDTO.setCustomerProfiles(customerProfileDTOList.subList(offset, upperBound));
                    customerProfilesDTO.setCount(customerProfileDTOList.size());
                } else {
                    throw new IndexOutOfBoundsException();
                }
            }
            return ResponseEntity.ok(customerProfilesDTO);

        } catch (IndexOutOfBoundsException exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Offset and Limit are not in the range");
        }
    }


    @GetMapping("/{customerId}")
    public ResponseEntity getExporterProfile(@PathVariable("customerId") long customerId) {
        try {

            CustomerProfileDTO customerProfileDTO = customerFacade.getCustomerInformation(customerId);
            return ResponseEntity.ok(customerProfileDTO);

        } catch (HttpClientErrorException.NotFound exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("There is customer with an ID" + customerId );
        }

    }


    @PostMapping
    public void addCustomer(@RequestBody  CustomerProfileDTO customerProfileDTO){
        //todo check if customer exists in facade
        customerFacade.addCustomer(customerProfileDTO);
    }


}
