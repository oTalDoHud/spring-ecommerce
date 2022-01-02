package com.example.aula01.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.aula01.model.entities.Order;

public interface OrderRepository  extends JpaRepository<Order, Integer>{

}
