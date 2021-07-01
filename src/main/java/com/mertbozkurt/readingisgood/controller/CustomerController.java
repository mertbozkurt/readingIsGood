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
    public ResponseEntity getAllCustomerProfiles(@RequestParam(value = "updatedAfter", required = false) String updatedAfter,
                                                 @RequestParam(value = "offset", required = false, defaultValue = "0") int offset,
                                                 @RequestParam(value = "limit", required = false, defaultValue = "100") int limit) {

        try {
            CustomerProfilesDTO customerProfilesDTO = new CustomerProfilesDTO();
            List<CustomerProfileDTO> customerProfileDTOList = customerFacade.getCustomerProfiles(convertStringToLocalDateTime(updatedAfter));
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

        } catch (DateTimeParseException exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("updatedAfter parameter should be yyyy-MM-dd'T'HH:mm:ss.SS format ");
        } catch (IndexOutOfBoundsException exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Offset and Limit are not in the range");
        }
    }


    @PostMapping(path = "/add")
    public void addCustomer(@RequestBody  CustomerProfileDTO customerProfileDTO){
        //todo check if customer exists in facade
        customerFacade.addCustomer(customerProfileDTO);
    }
    private LocalDateTime convertStringToLocalDateTime(String date) {

        LocalDateTime updateDateTime = null;
        if (date != null) {
            updateDateTime = LocalDateTime.parse(date, dateTimeFormatter);
        }
        return updateDateTime;
    }

}
