package com.brt.studentapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.brt.studentapp.controller.holder.MatpelDataHolder;
import com.brt.studentapp.model.Matpel;
import com.brt.studentapp.model.MatpelEndpoint;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

@Controller
public class MatpelController {

	MatpelDataHolder holder;
	
	@RequestMapping("admin/matpelHome")
	public ModelAndView matpelHome (HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		holder = new MatpelDataHolder();
		mav.setViewName("matpel");
		mav.addObject("form", holder);
		return mav;
	}
	
	@RequestMapping("admin/addMatpel")
	public ModelAndView addMatpel (@ModelAttribute ("form") MatpelDataHolder form, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		Matpel m = new Matpel();
		Key k = KeyFactory.createKey("Matpel", form.getMatpelName());
		m.setKey(k);
		MatpelEndpoint me = new MatpelEndpoint();
		me.insertMatpel(m);
		mav.setViewName("matpel");
		return mav;
		
	}
}
