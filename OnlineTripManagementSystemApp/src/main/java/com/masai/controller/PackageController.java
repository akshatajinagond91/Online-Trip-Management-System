package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.masai.service.PackageService;

@RestController
public class PackageController {

	@Autowired
	PackageService packageService;
	
	
	
}
