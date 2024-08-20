package com.chethanawijesinghe.pointOfSales.service.serviceImpl;

import com.chethanawijesinghe.pointOfSales.dto.RequestItemSaveDTO;
import com.chethanawijesinghe.pointOfSales.entity.Item;
import com.chethanawijesinghe.pointOfSales.repository.ItemRepo;
import com.chethanawijesinghe.pointOfSales.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
public class ItemIMPL implements ItemService {
    @Autowired
    private ModelMapper modelMapper;


    @Autowired
    private ItemRepo itemRepo;


    //to save items
    @Override
    public void addItem(RequestItemSaveDTO requestItemSaveDTO) {
        Item item = modelMapper.map(requestItemSaveDTO, Item.class);
        if (!itemRepo.existsById(item.getItemId())) {
            itemRepo.save(item);

        } else {
            throw new DuplicateKeyException("Already in the list");
        }
    }
}
