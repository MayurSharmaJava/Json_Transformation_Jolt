package com.mayur.joltdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is Spec controller for Jolt
 * responsibility
 * 1. save/Update Jolt Spec
 * 2. keep History of Jolt Spec changes
 * 3. get jolt Spec on basis of name
 * 4. get History of Jolt Spec on basis of Name
 */
@RestController
@RequestMapping("/api/spec/")
public class JoltSpecController {

	@GetMapping("/{name}")
	public String getSpec(@PathVariable(value = "name") String name) {
		/**
		 * on the basis of Spec name get Spec from database
		 */
		return "[   {     \"operation\": \"shift\",     \"spec\": {       \"firstName\": \"name\"     }   } ]";
	}
}
