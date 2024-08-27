package com.chethanawijesinghe.pointOfSales.dto.paginated;

import com.chethanawijesinghe.pointOfSales.dto.ItemDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaginatedResponseItemDTO {
    private List<ItemDTO> list;
    private  long dataCount;

}
