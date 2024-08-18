package com.chethanawijesinghe.pointOfSales.repository;

import com.chethanawijesinghe.pointOfSales.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface CustomerRepo  extends JpaRepository<Customer,Integer> {
    Optional<Customer> findByNicEquals(String nic);
}
