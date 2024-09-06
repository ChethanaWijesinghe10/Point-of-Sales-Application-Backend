package com.chethanawijesinghe.pointOfSales.dto.paginated;

import com.chethanawijesinghe.pointOfSales.dto.Response.ResponseOrderDetailsDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedResponseOrderDetailsDTO {
    private List<ResponseOrderDetailsDTO> list;
    private long dataCount;
}
