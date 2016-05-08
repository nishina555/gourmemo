package com.myproject.service;

import com.myproject.domain.Shop;
import com.myproject.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nishina on 2016/05/07.
 */

@Service
public class ShopService {
    @Autowired
    ShopRepository shopRepository;

    public Shop save(Shop shop) {
        return shopRepository.save(shop);
    }

    public List<Shop> findAll() {
        return shopRepository.findAll();
    }
}
