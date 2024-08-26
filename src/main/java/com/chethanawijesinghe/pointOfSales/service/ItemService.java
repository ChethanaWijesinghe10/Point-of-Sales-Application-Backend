package com.chethanawijesinghe.pointOfSales.service;

import com.chethanawijesinghe.pointOfSales.dto.ItemDTO;
import com.chethanawijesinghe.pointOfSales.dto.RequestItemSaveDTO;

import java.util.List;

public interface ItemService {
    void addItem(RequestItemSaveDTO requestItemSaveDTO);

    List<ItemDTO> getItemByNameAndActiveState(String itemName);
}
