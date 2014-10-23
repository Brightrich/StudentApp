package com.brt.studentapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.brt.studentapp.controller.holder.FacilityDataHolder;
import com.brt.studentapp.model.Facility;
import com.brt.studentapp.model.FacilityEndpoint;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Text;


@Controller
public class FacilityController {

	FacilityDataHolder holder;
	
	@RequestMapping("admin/facilityHome")
	public ModelAndView facilityHome (HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		holder = new FacilityDataHolder();
		mav.setViewName("facility");
		mav.addObject("form", holder);
		return mav;
	}
	
	@RequestMapping("admin/addFacility")
	public ModelAndView addFacility (@ModelAttribute ("form") FacilityDataHolder form, HttpServletRequest request) {
		System.out.println(form.getFacilityName());
		ModelAndView mav = new ModelAndView();
		Facility f = new Facility();
		Key k = KeyFactory.createKey("Facility", form.getFacilityName());
		f.setKey(k);
		Text t = new Text(form.getFacilityContent());
		f.setContent(t);
		FacilityEndpoint fe = new FacilityEndpoint();
		fe.insertFacility(f);
		mav.setViewName("facility");
		return mav;
		
	}
	
}
