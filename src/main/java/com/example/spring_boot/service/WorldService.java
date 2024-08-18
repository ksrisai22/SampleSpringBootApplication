package com.example.spring_boot.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_boot.model.City;
import com.example.spring_boot.repository.WorldRepository;

@Service
public class WorldService {
	
	@Autowired
	private WorldRepository worldRepo;
	
	Logger logger = LoggerFactory.getLogger(WorldService.class);
	
	public String someService() {
		logger.debug("In World Service");
		Optional<City> citiesIterable = worldRepo.findById(2);
		return "<h1>From Some Service<h1>";
	}

}
