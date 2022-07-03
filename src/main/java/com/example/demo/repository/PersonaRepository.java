package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Persona;

public interface PersonaRepository extends MongoRepository<Persona, Long> {

}
