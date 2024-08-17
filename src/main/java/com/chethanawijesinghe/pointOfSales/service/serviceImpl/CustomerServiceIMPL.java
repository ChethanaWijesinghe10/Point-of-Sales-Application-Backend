package com.chethanawijesinghe.pointOfSales.service.serviceImpl;

import com.chethanawijesinghe.pointOfSales.dto.CustomerDTO;
import com.chethanawijesinghe.pointOfSales.entity.Customer;
import com.chethanawijesinghe.pointOfSales.repository.CustomerRepo;
import com.chethanawijesinghe.pointOfSales.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceIMPL implements CustomerService {

  @Autowired
  private CustomerRepo customerRepo;

   // to save a new customer
    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        Customer customer=new Customer(
                customerDTO.getCustomerName(),
                customerDTO.getCustomerAddress(),
                customerDTO.getCustomerSalary(),
                customerDTO.getNic(),
                customerDTO.getCustomerNumber(),
                customerDTO.isActiveStatus()
        );
        if (customerRepo.existsById(customer.getCustomerId())) {
            throw new DuplicateKeyException("Customer Already Exist");
        } else {

            customerRepo.save(customer);

        }

    }
}
