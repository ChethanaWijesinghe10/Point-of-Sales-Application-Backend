package com.chethanawijesinghe.pointOfSales.service;

import com.chethanawijesinghe.pointOfSales.dto.RequestOrderSaveDTO;
import com.chethanawijesinghe.pointOfSales.dto.paginated.PaginatedResponseOrderDetailsDTO;

public interface OrderService {
    String addOrder(RequestOrderSaveDTO requestOrderSaveDTO);

    PaginatedResponseOrderDetailsDTO getAllOrderDetails(boolean state, int page, int size);
}
