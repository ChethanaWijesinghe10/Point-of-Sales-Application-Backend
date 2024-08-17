package com.chethanawijesinghe.pointOfSales.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="customer")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer {
 @Id
    @Column(name="customer_id" ,length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;


 @Column(name = "customer_name",length = 100)
    private String customerName;

 @Column(name="customer_address")
    private String customerAddress;

 @Column(name = "customer_salary",length = 100)
    private double customerSalary;

 @Column(name="nic")
    private String nic;

 @Column(name="contact_number",length=100)
    private int customerNumber;

 @Column(name="active_state",columnDefinition ="TINYINT default 1" )
 private boolean activeStatus;


}
