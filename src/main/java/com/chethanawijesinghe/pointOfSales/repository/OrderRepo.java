package com.chethanawijesinghe.pointOfSales.repository;

import com.chethanawijesinghe.pointOfSales.dto.OrderDetailsInterface;
import com.chethanawijesinghe.pointOfSales.entity.Order;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface OrderRepo extends JpaRepository <Order,Integer> {

    @Query(value = "select c.customer_name as CustomerName, c.customer_address as customerAddress," +
            " o.order_date as date, o.total as total from customer c, orders o" +
            "where o.active_state=?1 and c.customer_id=o.customer_id",nativeQuery = true)
    List<OrderDetailsInterface> getAllOrderDetails(boolean state, PageRequest of);
    @Query(value = "select count(*) from customer c, orders o" +
            "where o.active_state=?1 and c.customer_id=o.customer_id",nativeQuery = true)
    long countAllOrderDetails(boolean state);
}
