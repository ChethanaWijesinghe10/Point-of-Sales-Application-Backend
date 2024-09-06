package com.chethanawijesinghe.pointOfSales.controller;

import com.chethanawijesinghe.pointOfSales.dto.RequestOrderSaveDTO;
import com.chethanawijesinghe.pointOfSales.dto.paginated.PaginatedResponseOrderDetailsDTO;
import com.chethanawijesinghe.pointOfSales.service.OrderService;
import com.chethanawijesinghe.pointOfSales.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;

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


    @GetMapping(
            params = {"stateType", "page","size"},
            path = {"/get-order-default"}
    )
    public ResponseEntity<StandardResponse> getAllOrderDetails(
            @RequestParam(value = "stateType") String stateType,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size")@Max(50) int size
    ){
        PaginatedResponseOrderDetailsDTO paginatedResponseOrderDetailsDTO = null;
        if(stateType.equalsIgnoreCase("active") | stateType.equalsIgnoreCase("inactive")){
            boolean state =stateType.equalsIgnoreCase("active")?true:false;
            paginatedResponseOrderDetailsDTO = orderService.getAllOrderDetails(state,page,size);

        }
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success",paginatedResponseOrderDetailsDTO),
                HttpStatus.OK
        );}

}
