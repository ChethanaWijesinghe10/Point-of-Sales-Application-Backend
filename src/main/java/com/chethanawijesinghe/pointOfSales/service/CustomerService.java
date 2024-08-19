package com.chethanawijesinghe.pointOfSales.service;

import com.chethanawijesinghe.pointOfSales.dto.CustomerDTO;
import com.chethanawijesinghe.pointOfSales.dto.RequestUpdateCustomerDTO;

import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDTO customerDTO);

    void updateCustomer(RequestUpdateCustomerDTO requestUpdateCustomerDTO);

    String deleteCustomer(int customerId);

    List<CustomerDTO> getAllCustomers();

    CustomerDTO getCustomerByNic(String nic);

    List<CustomerDTO> getAllCustomersByActiveStatus(boolean activeStatus);

    List<CustomerDTO> getAllCustomersByActiveStatusAndName(String customerName);
}
