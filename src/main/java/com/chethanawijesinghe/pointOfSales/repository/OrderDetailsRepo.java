package com.chethanawijesinghe.pointOfSales.repository;

import com.chethanawijesinghe.pointOfSales.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface OrderDetailsRepo extends JpaRepository<OrderDetails,Integer> {
}
