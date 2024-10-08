package com.chethanawijesinghe.pointOfSales.controller;

import com.chethanawijesinghe.pointOfSales.dto.CustomerDTO;
import com.chethanawijesinghe.pointOfSales.dto.RequestUpdateCustomerDTO;
import com.chethanawijesinghe.pointOfSales.repository.CustomerRepo;
import com.chethanawijesinghe.pointOfSales.service.CustomerService;
import com.chethanawijesinghe.pointOfSales.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@CrossOrigin

public class CustomerController {

  @Autowired
    CustomerService customerService;

  @Autowired
  private CustomerRepo customerRepo;

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


  //Delete customers
@DeleteMapping(path="/delete/{id}")
public String deleteCustomer(@PathVariable(value = "id") int customerId){
  String deleted=customerService.deleteCustomer(customerId);
  return deleted;
}


//to get all customers
  @GetMapping(path = "/get-all-customers")
  public ResponseEntity<StandardResponse> getAllCustomers(){
    List<CustomerDTO> allCustomers =customerService.getAllCustomers();
    return new ResponseEntity<StandardResponse>(
            new StandardResponse(200,"All the customers are displayed",allCustomers),
            HttpStatus.OK
    );
  }



  //Get customer by nic
  @GetMapping(path="/get-by-nic",
          params="nic")
  public ResponseEntity<StandardResponse> getCustomerById(@RequestParam (value = "nic") String nic){
    CustomerDTO customerDTO=customerService.getCustomerByNic(nic)  ;

    return new ResponseEntity<StandardResponse>(
            new StandardResponse(200,"The customer of the specific nic is displayed. ",customerDTO),
            HttpStatus.OK
    );
  }


  //Get customers by active state
  @GetMapping(path = "/get-all-customers-by-active-state/{status}")
  public ResponseEntity<StandardResponse> getAllCustomersByActiveState(@PathVariable (value = "status") boolean activeStatus){
    List<CustomerDTO> allCustomers= customerService.getAllCustomersByActiveStatus(activeStatus);
    return new ResponseEntity<StandardResponse>(
            new StandardResponse(200,"All the customers who are active are displayed. ",allCustomers),
            HttpStatus.OK
    );
    }


    //Get customers by active state and name
  @GetMapping(path = "/get-all-customers-by-active-status-and-name/{name}")
  public ResponseEntity<StandardResponse> getAllCustomersByActiveStatusAndName(@PathVariable (value ="name" )String customerName){
    List<CustomerDTO> allCustomers= customerService.getAllCustomersByActiveStatusAndName(customerName);
    return new ResponseEntity<StandardResponse>(
            new StandardResponse(200,"The active customer of the given name is displayed. ",allCustomers),
            HttpStatus.OK
    );
  }

  }


