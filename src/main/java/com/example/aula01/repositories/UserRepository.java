package com.example.aula01.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.aula01.model.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
