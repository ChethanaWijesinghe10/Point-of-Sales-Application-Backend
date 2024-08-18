package com.chethanawijesinghe.pointOfSales.service.serviceImpl;

import com.chethanawijesinghe.pointOfSales.dto.CustomerDTO;
import com.chethanawijesinghe.pointOfSales.dto.RequestUpdateCustomerDTO;
import com.chethanawijesinghe.pointOfSales.entity.Customer;
import com.chethanawijesinghe.pointOfSales.repository.CustomerRepo;
import com.chethanawijesinghe.pointOfSales.service.CustomerService;
import com.chethanawijesinghe.pointOfSales.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Override
    public void updateCustomer(RequestUpdateCustomerDTO customerDTO) {
        if(customerRepo.existsById(customerDTO.getCustomerId())){
            Customer customer= customerRepo.getById(customerDTO.getCustomerId());

            customer.setCustomerName(customerDTO.getCustomerName());
            customer.setCustomerAddress(customerDTO.getCustomerAddress());
            customer.setCustomerSalary(customerDTO.getCustomerSalary());
            customerRepo.save(customer);

        }
        else{
            throw new RuntimeException("Customer is not in database");
        }

        }

    @Override
    public String deleteCustomer(int customerId) {

        if(customerRepo.existsById(customerId)){
            customerRepo.deleteById(customerId);
            return "Deleted Successfully";
        }
        else {
            return  "No Customer found in that id.";
        }

    }
    //Get all the customer list
    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer>getCustomer=customerRepo.findAll();
        List<CustomerDTO> customerDTOList =new ArrayList<>();
        for (Customer customer: getCustomer ) {
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getCustomerSalary(),
                    customer.getNic(),
                    customer.getCustomerNumber(),
                    customer.isActiveStatus()
            );
            customerDTOList.add(customerDTO);
        }
        return customerDTOList;

    }

    @Override
    public CustomerDTO getCustomerByNic(String nic) {
        Optional<Customer> customer = customerRepo.findByNicEquals(nic);
        if (customer.isPresent()) {
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.get().getCustomerId(),
                    customer.get().getCustomerName(),
                    customer.get().getCustomerAddress(),
                    customer.get().getCustomerSalary(),
                    customer.get().getNic(),
                    customer.get().getCustomerNumber(),
                    customer.get().isActiveStatus()
            );
            return customerDTO;
        } else {
            throw new RuntimeException("Customer not found");

        }


    }
}

