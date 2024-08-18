package com.chethanawijesinghe.pointOfSales.service;

import com.chethanawijesinghe.pointOfSales.dto.CustomerDTO;
import com.chethanawijesinghe.pointOfSales.dto.RequestUpdateCustomerDTO;

public interface CustomerService {
    void saveCustomer(CustomerDTO customerDTO);

    void updateCustomer(RequestUpdateCustomerDTO requestUpdateCustomerDTO);

    String deleteCustomer(int customerId);
}
