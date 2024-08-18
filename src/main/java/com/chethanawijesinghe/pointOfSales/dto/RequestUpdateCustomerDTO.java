package com.chethanawijesinghe.pointOfSales.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestUpdateCustomerDTO {
    private int customerId;
    private String customerName;
    private String customerAddress;
    private double customerSalary;
}