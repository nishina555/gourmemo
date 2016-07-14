package com.myproject.service;

import com.myproject.domain.Shop;
import com.myproject.domain.User;
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

    public List<Shop> findByUser(User user) {
        return shopRepository.findByUser(user);
    }

    public Shop findByName(String name) {
        return shopRepository.findByName(name);
    }

    public Shop create(Shop shop, User user) {
        shop.setUser(user);
        return shopRepository.save(shop);
    }

    public Shop update(Shop shop, User user) {
        shop.setUser(user);
        return shopRepository.save(shop);
    }

    public void delete(Integer id) {
        shopRepository.delete(id);

    }

    public void deleteByName(String name) {
        shopRepository.deleteByName(name);
    }

    public List<Shop> findByNoteLikeAndUser(String note, User user){
        return shopRepository.findByNoteLikeAndUser(note, user);
    }
}
