package com.chethanawijesinghe.pointOfSales.controller;

import com.chethanawijesinghe.pointOfSales.dto.ItemDTO;
import com.chethanawijesinghe.pointOfSales.dto.RequestItemSaveDTO;
import com.chethanawijesinghe.pointOfSales.service.ItemService;
import com.chethanawijesinghe.pointOfSales.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/item")
@CrossOrigin
@Validated
public class ItemController {

    @Autowired
    private ItemService itemService;

    //save item
    @PostMapping(path = "/save")
    public ResponseEntity<StandardResponse> saveItem(@RequestBody RequestItemSaveDTO requestItemSaveDTO){

        itemService.addItem(requestItemSaveDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Item saved successfully! ",requestItemSaveDTO),
                HttpStatus.OK
        );

    }


    @GetMapping(path="/get-by-name",
            params = "name")
    public List<ItemDTO> getItemByNameAndActiveState(@RequestParam(value = "name")String itemName){
        List<ItemDTO> itemDTOS =itemService.getItemByNameAndActiveState(itemName);
        return  itemDTOS;
    }


    //by using standard response
    @GetMapping(path="/get-by-name-1",
            params = "name")
    public ResponseEntity<StandardResponse> getItemByNameAndActiveState1(@RequestParam(value = "name")String itemName){
        List<ItemDTO> itemDTOS =itemService.getItemByNameAndActiveState(itemName);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success",itemDTOS),
                HttpStatus.OK
        );
    }
}
