package com.mayur.joltdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/external/customerId/")
public class ExternalDataController {

	@GetMapping("/{id}")
	public String getCustomerData(@PathVariable(value = "id") long id) {
		return "{  \"firstName\": \"John\", \"lastName\": \"Smith\", \"age\": 25     }";
	}
}
