package com.chethanawijesinghe.pointOfSales.controller;

import com.chethanawijesinghe.pointOfSales.dto.CustomerDTO;
import com.chethanawijesinghe.pointOfSales.dto.RequestUpdateCustomerDTO;
import com.chethanawijesinghe.pointOfSales.service.CustomerService;
import com.chethanawijesinghe.pointOfSales.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
@CrossOrigin

public class CustomerController {

  @Autowired
    CustomerService customerService;

  //method to save new customers
    @PostMapping(path = "/save-customer")
    public ResponseEntity<StandardResponse> saveCustomer(@RequestBody CustomerDTO customerDTO){
      customerService.saveCustomer(customerDTO);
      return new ResponseEntity<StandardResponse>(
              new StandardResponse(200,"Successfully Added a New Customer",customerDTO),
              HttpStatus.OK
      );
    }


    //Update customers
  @PutMapping(path="/update-customer")
  public ResponseEntity<StandardResponse> updateCustomer(@RequestBody RequestUpdateCustomerDTO customerDTO){
      customerService.updateCustomer(customerDTO);
    return new ResponseEntity<StandardResponse>(
            new StandardResponse(200,"Successfully  Updated the Customer",customerDTO),
            HttpStatus.OK
    );
  }
}
