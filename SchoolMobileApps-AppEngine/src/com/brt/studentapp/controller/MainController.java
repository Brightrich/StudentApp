package com.brt.studentapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	
	@RequestMapping("/")
	public ModelAndView homePage(ModelAndView mav){
		mav.setViewName("index");							
		return mav;
	}
	
}