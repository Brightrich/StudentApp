package com.brt.studentapp.controller;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.brt.studentapp.controller.holder.StaffDataHolder;
import com.brt.studentapp.model.Kelas;
import com.brt.studentapp.model.KelasEndpoint;
import com.brt.studentapp.model.Staff;
import com.brt.studentapp.model.StaffEndpoint;
import com.brt.studentapp.model.User;
import com.brt.studentapp.model.UserEndpoint;
import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.datastore.Blob;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

@Controller
public class StaffController {

	StaffDataHolder holder;
	
	@RequestMapping("admin/staffHome")
	public ModelAndView locationHome (HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		holder = new StaffDataHolder();
		
		KelasEndpoint kl = new KelasEndpoint();
		List<Kelas> kelasList = (List<Kelas>) kl.listKelas(null, null).getItems();
		HashMap<String, String> kelasMap = new HashMap<String, String>();
		HashMap<String, Kelas> kelasKeyMap = new HashMap<String, Kelas>();
		for (Kelas r : kelasList){
			kelasMap.put(r.getKey().getName(), r.getKey().getName());
			kelasKeyMap.put(r.getKey().getName(), r);
		}
		holder.setKelasMap(kelasMap);
		holder.setKelasKeyMap(kelasKeyMap);
		
		
		mav.setViewName("staff");
		mav.addObject("form", holder);
		return mav;
	}
	
	@RequestMapping("admin/addStaff")
	public ModelAndView addLocation (@ModelAttribute("form") StaffDataHolder form, HttpServletRequest request) throws FileUploadException, IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		ModelAndView mav = new ModelAndView();
		ServletFileUpload upload = new ServletFileUpload();
		Staff l = new Staff();
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
		        l.setPhoto(blob);
		        // Process the input stream

		    }
		}									
		
		Key k = KeyFactory.createKey("Staff", form.getStaffNIK());
		/*Entity e = new Entity("MatPelDetail", k);
		l.setKey(e.getKey());*/
		l.setKey(k);
		l.setName(form.getStaffName());
		l.setJabatan(form.getStaffRole());
		StaffEndpoint se = new StaffEndpoint();
		se.insertStaff(l);
		mav.setViewName("staff");
		return mav;
	}
	
	@RequestMapping("admin/addStudent")
	public ModelAndView addStudent (@ModelAttribute("form") StaffDataHolder form, HttpServletRequest request) throws FileUploadException, IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		ModelAndView mav = new ModelAndView();
		ServletFileUpload upload = new ServletFileUpload();
		User u = new User();
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
		        u.setPhoto(blob);
		        // Process the input stream

		    }
		}									
		
		Key k = KeyFactory.createKey("User", form.getStudentNIS());
		/*Entity e = new Entity("MatPelDetail", k);
		l.setKey(e.getKey());*/
		u.setKey(k);
		u.setFirstName(form.getStudentFirstName());
		u.setEmail(form.getStudentEmail());
		u.setImsi(form.getStudentIMSI());
		u.setKelas(form.getKelas());
		u.setLastName(form.getStudentLastName());
		u.setPhoneNumber(form.getStudentPhone());
		
		UserEndpoint se = new UserEndpoint();
		se.insertUser(u);
		mav.setViewName("staff");
		return mav;
	}
}
