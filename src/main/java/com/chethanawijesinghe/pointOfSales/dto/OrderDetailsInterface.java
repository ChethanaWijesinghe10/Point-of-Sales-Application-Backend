package com.chethanawijesinghe.pointOfSales.dto;

import java.util.Date;

public interface OrderDetailsInterface {
    //customer
    String getCustomerName();
    String getCustomerAddress();

    //order
    Date getDate();
    Double getTotal();
}
