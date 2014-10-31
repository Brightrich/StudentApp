package com.brt.studentapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.brt.studentapp.controller.holder.MatpelDetailDataHolder;
import com.brt.studentapp.model.Kelas;
import com.brt.studentapp.model.KelasEndpoint;
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
		
		HashMap<String, String> matpelMap = new HashMap<String, String>();
		HashMap<String, Matpel> matPelKeyMap = new HashMap<String, Matpel>();
		HashMap<String, String> kelasMap = new HashMap<String, String>();
		
		
		MatpelEndpoint mp = new MatpelEndpoint();
		List<Matpel> matpelList = (List<Matpel>) mp.listMatpel(null, null).getItems();
		
		for (Matpel q : matpelList){
			matpelMap.put(q.getKey().getName(), q.getKey().getName());
			matPelKeyMap.put(q.getKey().getName(), q);
		}
		
		KelasEndpoint ep = new KelasEndpoint();
		List<Kelas> kelasList = (List<Kelas>) ep.listKelas(null, null).getItems();
		for(Kelas k : kelasList){
			kelasMap.put(k.getKey().getName(), k.getKey().getName());			
		}
		
		holder.setMatpelMap(matpelMap);
		holder.setMatpelKeyMap(matPelKeyMap);
		holder.setKelasMap(kelasMap);
		
		mav.setViewName("matpelDetail");
		mav.addObject("form", holder);
		
		MatpelDetailEndpoint me = new MatpelDetailEndpoint();
		List<MatpelDetail> list = (List<MatpelDetail>) me.listMatpelDetailByParent("Matematika","123", null, null).getItems();
		for (MatpelDetail matpelDetail : list) {
			System.out.println(matpelDetail.getTitle());
		}
		
		return mav;
	}
	
	@RequestMapping("admin/addMatpelDetail")
	public ModelAndView addMatpelDetail (@ModelAttribute ("form") MatpelDetailDataHolder form, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		MatpelDetail md = new MatpelDetail();
		Matpel matpel = holder.getMatpelKeyMap().get(form.getMatpel());
		//System.out.println("MATPEL= " + matpel.getKey().getName() + " ID = " + matpel.getKey().getId());
		Key k = KeyFactory.createKey("MatpelDetail", UUID.randomUUID().getMostSignificantBits());
		
		//Entity e = new Entity("MatpelDetail", matpel.getKey());
		
		md.setKey(k);
		System.out.println("CLASS= "  + form.getMatpelDetailClass());
		System.out.println("TITLE= " + form.getMatpelDetailTitle());
		System.out.println("CONTENT= " + form.getMatpelDetailContent());
		md.setMatpelName(matpel.getKey().getName());
		md.setKelas(form.getMatpelDetailClass());
		md.setTitle(form.getMatpelDetailTitle());
		Text t = new Text(form.getMatpelDetailContent());
		md.setContent(t);
		MatpelDetailEndpoint me = new MatpelDetailEndpoint();
		me.insertMatpelDetail(md);
		
		mav.addObject("form", holder);
		mav.setViewName("matpelDetail");
		return mav;
	}
}
