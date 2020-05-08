package com.resttemplate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/request")
public class RequestController {

	@GetMapping("/index")
	public ModelAndView view() {
		ModelAndView modelView = new ModelAndView("views/index");
		return modelView;
	}
	
	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView modelView = new ModelAndView("views/list");
		return modelView;
	}
	
}