package com.brt.studentapp.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.brt.studentapp.controller.holder.MatpelDetailDataHolder;
import com.brt.studentapp.model.Matpel;
import com.brt.studentapp.model.MatpelDetail;
import com.brt.studentapp.model.MatpelDetailEndpoint;
import com.brt.studentapp.model.MatpelEndpoint;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Text;

@Controller
public class MatpelDetailController {

	MatpelDetailDataHolder holder;
	
	@RequestMapping("admin/matpelDetailHome")
	public ModelAndView matpelDetailHome (HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		holder = new MatpelDetailDataHolder();
		
		MatpelEndpoint mp = new MatpelEndpoint();
		List<Matpel> matpelList = (List<Matpel>) mp.listMatpel(null, null).getItems();
		HashMap<String, String> matpelMap = new HashMap<String, String>();
		HashMap<String, Matpel> matPelKeyMap = new HashMap<String, Matpel>();
		for (Matpel q : matpelList){
			matpelMap.put(q.getKey().getName(), q.getKey().getName());
			matPelKeyMap.put(q.getKey().getName(), q);
		}
		holder.setMatpelMap(matpelMap);
		holder.setMatpelKeyMap(matPelKeyMap);
		mav.setViewName("matpelDetail");
		mav.addObject("form", holder);
		return mav;
	}
	
	@RequestMapping("admin/addMatpelDetail")
	public ModelAndView addMatpelDetail (@ModelAttribute ("form") MatpelDetailDataHolder form, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		MatpelDetail md = new MatpelDetail();
		Matpel matpel = holder.getMatpelKeyMap().get(form.getMatpel());
		//Key k = KeyFactory.createKey("MatpelDetail", matpel.getKey());
		Entity e = new Entity("MatpelDetail", matpel.getKey());
		md.setKey(e.getKey());
		md.setKelas(form.getMatpelDetailClass());
		md.setTitle(form.getMatpelDetailTitle());
		Text t = new Text(form.getMatpelDetailContent());
		md.setContent(t);
		MatpelDetailEndpoint me = new MatpelDetailEndpoint();
		me.insertMatpelDetail(md);
		mav.setViewName("matpelDetail");
		return mav;
	}
}
