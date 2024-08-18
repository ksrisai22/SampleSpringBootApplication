package com.example.spring_boot.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import com.example.spring_boot.model.City;

@Repository
public interface WorldRepository extends CrudRepository<City, Integer>{

	
}
