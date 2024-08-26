package com.chethanawijesinghe.pointOfSales.util;

import com.chethanawijesinghe.pointOfSales.dto.ItemDTO;
import com.chethanawijesinghe.pointOfSales.entity.Item;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;
@Mapper(componentModel ="spring" )
public interface ItemMapper {
    List<ItemDTO> entityListToDTOList(List<Item> items);
    List<ItemDTO> pageToList(Page<Item> items);
}
