package com.chethanawijesinghe.pointOfSales.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class CustomerDTO {
    private int customerId;
    private String customerName;
    private String customerAddress;
    private double customerSalary;
    private String nic;
    private int customerNumber;
    private boolean activeStatus;
}
