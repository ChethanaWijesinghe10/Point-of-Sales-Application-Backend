package com.chethanawijesinghe.pointOfSales.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "item")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private int itemId;

    @Column(name="item_name", length = 100, nullable = false)
    private String itemName;

    @Enumerated(EnumType.STRING)
    @Column(name="measure_type", length = 100, nullable = false)
    private MeasuringUnitType measuringUnitType;

    @Column(name="balance_qty", nullable = false)
    private double balanceQty;

    @Column(name="supplier_price", nullable = false)
    private double supplierPrice;

    @Column(name="selling_price", nullable = false)
    private double sellingPrice;

    @Column(name = "active_state", columnDefinition = "TINYINT(1) default 1")
    private boolean activeState;



}
