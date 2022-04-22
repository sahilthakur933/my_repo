package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dto.DBConfig;

@RestController
public class TestController {
	
	@Autowired
	DBConfig dbConfig;
	
	@Value("${spring.application.name}")
	private String appName;
	
	@GetMapping(value="/dbConfig")
	public String getDbConfig() {
		return this.dbConfig.toString();
	}
	
	@GetMapping(value="/appname")
	public String getAppName() {
		return this.appName;
		
	}
}
