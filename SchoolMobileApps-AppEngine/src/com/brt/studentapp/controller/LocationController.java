package com.brt.studentapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.brt.studentapp.controller.holder.LocationDataHolder;
import com.brt.studentapp.model.Page;
import com.brt.studentapp.model.PageEndpoint;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Text;

@Controller
public class LocationController {

	LocationDataHolder holder;
	
	@RequestMapping("admin/locationHome")
	public ModelAndView locationHome (HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		holder = new LocationDataHolder();
		mav.setViewName("location");
		mav.addObject("form", holder);
		return mav;
	}
	
	@RequestMapping("admin/addLocation")
	public ModelAndView addLocation (@ModelAttribute("form") LocationDataHolder form, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		Page l = new Page();
		Key k = KeyFactory.createKey("Page","Location");
		l.setKey(k);
		System.out.println(form.getLocationContent());
		Text t = new Text(form.getLocationContent().replace("&lt;", "<").replace("&gt;", ">"));
		l.setContent(t);
		PageEndpoint le = new PageEndpoint();
		le.insertPage(l);
		mav.setViewName("location");
		return mav;
	}
	
}
