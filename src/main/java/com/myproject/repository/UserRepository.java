package com.myproject.repository;

import com.myproject.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by nishina on 2016/07/09.
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByName(String name);
}