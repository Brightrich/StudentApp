package com.brt.studentapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalendarController {

	@RequestMapping("admin/calendarHome")
	private ModelAndView CalendarHome (ModelAndView mav) {
		mav.setViewName("calendar");
		return mav;
	}
}
