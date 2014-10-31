package com.brt.studentapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.brt.studentapp.controller.holder.JadwalPelajaranDataHolder;
import com.brt.studentapp.model.JadwalPelajaran;
import com.brt.studentapp.model.JadwalPelajaranEndpoint;
import com.brt.studentapp.model.Kelas;
import com.brt.studentapp.model.KelasEndpoint;
import com.brt.studentapp.model.Matpel;
import com.brt.studentapp.model.MatpelEndpoint;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

@Controller
public class JadwalPelajaranController {

	JadwalPelajaranDataHolder holder;
	
	@RequestMapping("admin/jadwalPelajaranHome")
	private ModelAndView JadwalPelajaranHome (HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		holder = new JadwalPelajaranDataHolder();
		MatpelEndpoint mp = new MatpelEndpoint();
		KelasEndpoint kl = new KelasEndpoint();
		List<Matpel> matpelList = (List<Matpel>) mp.listMatpel(null, null).getItems();
		HashMap<String, String> matpelMap = new HashMap<String, String>();
		HashMap<String, Matpel> matPelKeyMap = new HashMap<String, Matpel>();
		for (Matpel q : matpelList){
			matpelMap.put(q.getKey().getName(), q.getKey().getName());
			matPelKeyMap.put(q.getKey().getName(), q);
		}
		List<Kelas> kelasList = (List<Kelas>) kl.listKelas(null, null).getItems();
		HashMap<String, String> kelasMap = new HashMap<String, String>();
		HashMap<String, Kelas> kelasKeyMap = new HashMap<String, Kelas>();
		for (Kelas r : kelasList){
			kelasMap.put(r.getKey().getName(), r.getKey().getName());
			kelasKeyMap.put(r.getKey().getName(), r);
		}
		holder.setMatpelMap(matpelMap);
		holder.setMatpelKeyMap(matPelKeyMap);
		holder.setKelasMap(kelasMap);
		holder.setKelasKeyMap(kelasKeyMap);
		mav.setViewName("jadwalPelajaran");
		mav.addObject("form", holder);
		return mav;
	}
	
	@RequestMapping("admin/addJadwalPelajaran")
	private ModelAndView AddJadwalPelajaran (@ModelAttribute ("form") JadwalPelajaranDataHolder form, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		JadwalPelajaran md = new JadwalPelajaran();
		Matpel matpel = holder.getMatpelKeyMap().get(form.getMatpel());
		Kelas kelas = holder.getKelasKeyMap().get(form.getKelas());
		Key k = KeyFactory.createKey("JadwalPelajaran", UUID.randomUUID().getMostSignificantBits());
		md.setKey(k);
		md.setMatpelName(matpel.getKey().getName());
		md.setKelas(kelas.getKey().getName());
		md.setHari(form.getJadwalHari());
		md.setJamMulai(form.getJadwalMulaiJam() + "." + form.getJadwalMulaiMenit());
		md.setJamSelesai(form.getJadwalSelesaiJam() + "." + form.getJadwalSelesaiMenit());
		JadwalPelajaranEndpoint me = new JadwalPelajaranEndpoint();
		me.insertJadwalPelajaran(md);
		mav.addObject("form", holder);
		mav.setViewName("jadwalPelajaran");
		return mav;
	}
}
