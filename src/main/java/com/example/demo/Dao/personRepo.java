package com.example.demo.Dao;

import com.example.demo.Entities.person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface personRepo extends JpaRepository<person, Integer> {


    person findByName(String name);
}
