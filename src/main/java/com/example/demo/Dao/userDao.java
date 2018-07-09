package com.example.demo.Dao;

import com.example.demo.Entities.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userDao extends JpaRepository<user, Integer> {

    user findByUsername(String lastname);


}
