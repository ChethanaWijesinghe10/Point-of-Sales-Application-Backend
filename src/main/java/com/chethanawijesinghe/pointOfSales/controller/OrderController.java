package com.chethanawijesinghe.pointOfSales.controller;

import com.chethanawijesinghe.pointOfSales.dto.RequestOrderSaveDTO;
import com.chethanawijesinghe.pointOfSales.service.OrderService;
import com.chethanawijesinghe.pointOfSales.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(path = "api/v1/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(path = "/save")
    public RequestEntity<StandardResponse> saveItem(@RequestBody RequestOrderSaveDTO requestOrderSaveDTO){
        String id =orderService.addOrder(requestOrderSaveDTO);
        return  null;
    }
}
