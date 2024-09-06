package com.chethanawijesinghe.pointOfSales.service;

import com.chethanawijesinghe.pointOfSales.dto.RequestOrderSaveDTO;

public interface OrderService {
    String addOrder(RequestOrderSaveDTO requestOrderSaveDTO);
}
