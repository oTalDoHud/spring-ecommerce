package com.example.aula01.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.aula01.model.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer>{

}
