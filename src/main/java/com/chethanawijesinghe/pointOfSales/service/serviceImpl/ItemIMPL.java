package com.chethanawijesinghe.pointOfSales.service.serviceImpl;

import com.chethanawijesinghe.pointOfSales.dto.ItemDTO;
import com.chethanawijesinghe.pointOfSales.dto.RequestItemSaveDTO;
import com.chethanawijesinghe.pointOfSales.dto.paginated.PaginatedResponseItemDTO;
import com.chethanawijesinghe.pointOfSales.entity.Item;
import com.chethanawijesinghe.pointOfSales.repository.ItemRepo;
import com.chethanawijesinghe.pointOfSales.service.ItemService;
import com.chethanawijesinghe.pointOfSales.util.ItemMapper;
import com.chethanawijesinghe.pointOfSales.util.StandardResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class ItemIMPL implements ItemService {
    @Autowired
    private ModelMapper modelMapper;


    @Autowired
    ItemMapper itemMapper;
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

    @Override
    public List<ItemDTO> getItemByNameAndActiveState(String itemName) {
        List<Item> items = itemRepo.findAllByItemNameEqualsAndActiveStateEquals(itemName, true);
        List<ItemDTO> itemDTOS=itemMapper.entityListToDTOList(items);
        return itemDTOS;
    }

    @Override
    public PaginatedResponseItemDTO getItemActive(int page, int size, boolean activeState) {
        Page<Item> items=itemRepo.findAllByActiveStateEquals(activeState, PageRequest.of(page, size));

        return new PaginatedResponseItemDTO(
                itemMapper.pageToList(items),

                itemRepo.countAllByActiveStateEquals(activeState)
        );
    }

}
