package com.myproject.repository;

import com.myproject.domain.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by nishina on 2016/05/07.
 */

public interface ShopRepository extends JpaRepository<Shop, Integer>{
    Shop findByName(String name);
    Integer deleteByName(String name);

}