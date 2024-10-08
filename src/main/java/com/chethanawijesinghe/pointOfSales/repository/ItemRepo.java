package com.chethanawijesinghe.pointOfSales.repository;

import com.chethanawijesinghe.pointOfSales.entity.Item;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ItemRepo extends JpaRepository<Item,Integer> {

    List<Item> findAllByItemNameEqualsAndActiveStateEquals(String itemName, boolean b);

    Page<Item> findAllByActiveStateEquals(boolean activeState, Pageable pageable);

    long countAllByActiveStateEquals(boolean activeState);
}
