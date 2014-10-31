package com.brt.studentapp.controller;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.brt.studentapp.controller.holder.TugasDataHolder;
import com.brt.studentapp.model.Kelas;
import com.brt.studentapp.model.KelasEndpoint;
import com.brt.studentapp.model.Matpel;
import com.brt.studentapp.model.MatpelEndpoint;
import com.brt.studentapp.model.Tugas;
import com.brt.studentapp.model.TugasEndpoint;
import com.google.appengine.api.datastore.Blob;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

@Controller
public class TugasController {

	TugasDataHolder holder;
	
	@RequestMapping("admin/tugasHome")
	public ModelAndView TugasHome (HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		
		HashMap<String, String> matpelMap = new HashMap<String, String>();
		HashMap<String, String> kelasMap = new HashMap<String, String>();
		HashMap<String, Matpel> matPelKeyMap = new HashMap<String, Matpel>();
		
		
		holder = new TugasDataHolder();
		
		MatpelEndpoint mp = new MatpelEndpoint();
		List<Matpel> matpelList = (List<Matpel>) mp.listMatpel(null, null).getItems();
		
		KelasEndpoint ep = new KelasEndpoint();
		List<Kelas> kelasList = (List<Kelas>) ep.listKelas(null, null).getItems();
		
		
		for (Matpel q : matpelList){
			matpelMap.put(q.getKey().getName(), q.getKey().getName());
			matPelKeyMap.put(q.getKey().getName(), q);
		}
		
		for (Kelas k : kelasList){
			kelasMap.put(k.getKey().getName(), k.getKey().getName());
		}
		
		holder.setKelasMap(kelasMap);
		holder.setMatpelMap(matpelMap);
		holder.setMatpelKeyMap(matPelKeyMap);
		mav.setViewName("tugas");
		mav.addObject("form", holder);
		return mav;
	}
	@RequestMapping("admin/addTugas")
	public ModelAndView addTugas (@ModelAttribute ("form") TugasDataHolder form, HttpServletRequest request) throws FileUploadException, IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		ModelAndView mav = new ModelAndView();
		ServletFileUpload upload = new ServletFileUpload();
		Tugas t = new Tugas();
		// Parse the request
		FileItemIterator iter = upload.getItemIterator(request);
		while (iter.hasNext()) {
			FileItemStream item = iter.next();
			String name = item.getFieldName();
			InputStream stream = item.openStream();
				if (item.isFormField()) {
					String res = Streams.asString(stream);
				    System.out.println("Form field " + name + " with value "
				    + res + " detected.");
				    MethodUtils.invokeMethod(form, "set"+name, res);
				} else {
					System.out.println("File field " + name + " with file name "
				    + item.getName() + " detected.");
				    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
				    Streams.copy(stream, bytes, true);
				    Blob blob = new Blob(bytes.toByteArray());				    
				    t.setFile(blob);
				   // Process the input stream
				    }
				}
		Matpel matpel = holder.getMatpelKeyMap().get(form.getMatpel());
		Key k = KeyFactory.createKey("Tugas", UUID.randomUUID().getMostSignificantBits());
		t.setKey(k);
		t.setMatpelName(matpel.getKey().getName());
		t.setKelas(form.getTugasClass());
		t.setTitle(form.getTugasTitle());
		t.setFileType(form.getExtension());
		TugasEndpoint te = new TugasEndpoint();
		te.insertTugas(t);
		mav.addObject("form", holder);
		mav.setViewName("tugas");
		return mav;
	}
}
