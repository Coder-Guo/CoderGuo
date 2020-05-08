package com.activiti.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/json")
public class TestJsonController {

	@RequestMapping(value = "/postJson",method = RequestMethod.POST)
	public String get(@RequestBody String param) {
		if(param != null && param.length() > 0) {
			System.out.println(param);
		}
		return null;
	}
	
}