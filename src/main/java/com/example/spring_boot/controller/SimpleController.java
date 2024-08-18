package com.example.spring_boot.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_boot.service.WorldService;

import ch.qos.logback.classic.Logger;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class SimpleController {
	
	Logger logger = (Logger) LoggerFactory.getLogger(WorldService.class);
	
	@Autowired
	private WorldService worldService;
	
	@Operation(summary = "Welcome endpoint")
	@ApiResponses(value = { @ApiResponse })
	@GetMapping("/welcome")
	public String welcomeController() {
		logger.info("Called Simeple Controller");
		return worldService.userService();
	}
	
	@Operation(summary = "Admin endpoint")
	@ApiResponses(value = { @ApiResponse })
	@GetMapping("/admin")
	public String adminController() {
		logger.info("Called Simeple Controller");
		return worldService.adminService();
	}
	
	
		

}
