package com.chethanawijesinghe.pointOfSales.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestOrderDetailSaveDTO {
    private String itemName;
    private String qty;
    private Double amount;
    private int orders;
    private int items;
}
