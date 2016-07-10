package com.myproject.service;

import com.myproject.domain.Shop;
import com.myproject.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by nishina on 2016/05/08.
 */
@Service
@Transactional
public class ShopService {
    @Autowired
    ShopRepository shopRepository;

    public Shop findOne(Integer id) {
        return shopRepository.findOne(id);
    }

    public List<Shop> findAll() {
        return shopRepository.findAll();
    }

    public Shop findByName(String name) {
        return shopRepository.findByName(name);
    }

/*    public Shop create_join(Shop shop, User user) {
        shop.setUser(user);
        return shopRepository.save(shop);
    }*/

    public Shop create(Shop shop) {
        return shopRepository.save(shop);
    }

/*    public Shop update_join(Shop shop, User user) {
        shop.setUser(user);
        return shopRepository.save(shop);
    }*/

    public Shop update(Shop shop) {
        return shopRepository.save(shop);
    }

    public void deleteByName(String name) {
        shopRepository.deleteByName(name);
    }
}
