package com.myproject.repository;

import com.myproject.domain.Shop;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by nishina on 2016/05/07.
 */
@Repository
public class ShopRepository {
    private final ConcurrentMap<Integer, Shop> shopMap = new ConcurrentHashMap<>();

    public List<Shop> findAll() {
        return new ArrayList<>(shopMap.values());
    }

    public Shop findOne(Integer shopId) {
        return shopMap.get(shopId);
    }

    public Shop save(Shop shop) {
        return shopMap.put(shop.getId(), shop);
    }

    public void delete(Integer shopId) {
        shopMap.remove(shopId);
    }

}