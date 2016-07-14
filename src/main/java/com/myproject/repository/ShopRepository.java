package com.myproject.repository;

import com.myproject.domain.Shop;
import com.myproject.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by nishina on 2016/05/07.
 */

public interface ShopRepository extends JpaRepository<Shop, Integer>{
    Shop findByName(String name);
    Integer deleteByName(String name);
    List<Shop> findByUser(User user);
    @Query("SELECT x FROM Shop x WHERE x.note LIKE %:note% AND x.user = :user")
    List<Shop> findByNoteLikeAndUser(@Param("note") String note,@Param("user") User user);
}