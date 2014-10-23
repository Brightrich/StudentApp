package com.brt.studentapp.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.RespectBinding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.brt.studentapp.controller.holder.AnnouncementDataHolder;
import com.brt.studentapp.model.Announcement;
import com.brt.studentapp.service.AnnouncementService;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.urlfetch.HTTPRequest;
import com.google.appengine.api.urlfetch.HTTPResponse;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.gson.Gson;

@Controller
public class AnnouncementController {

	
	/*AnnouncementService announcementService;
			
	public void setAnnouncementService(AnnouncementService announcementService) {
		this.announcementService = announcementService;
	}*/

	AnnouncementDataHolder holder;
	/*UserService userService = UserServiceFactory.getUserService();
    User user = userService.getCurrentUser();*/

    @RequestMapping("admin/announcementDelete")
    public @ResponseBody String announcementNew(@ModelAttribute("form") AnnouncementDataHolder form) {
    	DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
    	datastore.delete(KeyFactory.stringToKey(form.getDeleteId()));
		return "";
    }
    
    @RequestMapping("admin/announcementList")
    public @ResponseBody String announcementList(@ModelAttribute("form") AnnouncementDataHolder form){
    	
    	DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
    	Query query = new Query("Announcement");
    	
    	System.out.println("MASUK");
    	
    	List<Announcement> annList = new ArrayList<Announcement>();
    	List<Entity> entList = null;
    	
    	if (form.getTitle_search().equals("")){
    		System.out.println("ALL");
    		entList = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
    	} else {
    		System.out.println("FILTERED");
    		entList = datastore.prepare(query.setFilter(FilterOperator.EQUAL.of("title", form.getTitle_search()))).asList(FetchOptions.Builder.withDefaults());
    	}
    	
    	for (Entity e : entList) {
    		Announcement a = new Announcement();
    		a.setId(KeyFactory.keyToString(e.getKey()));
    		a.setTitle((String) e.getProperty("title"));
    		a.setContent((String) e.getProperty("content"));
    		annList.add(a);
    	}
    	
    	
    	
    	Gson gson = new Gson();
    	String result = gson.toJson(annList);
		return result;
    	
    }
    

    @RequestMapping("admin/getRecentNews")
    public @ResponseBody String getRecentNewsFromAjax(){
    	
    	Gson gson = new Gson();
    	String result = gson.toJson(getRecentNews());
    	return result;
    	
    }
    
    public List<Announcement> getRecentNews(){
    	
    	DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		//Entity Announcement = new Entity("Announcement");
		Query query = new Query("Announcement").addSort("__key__", Query.SortDirection.DESCENDING);
		
		List<Announcement> listAnnouncement = new ArrayList<Announcement>();
		
		
		List<Entity> listEntity = datastore.prepare(query).asList(FetchOptions.Builder.withLimit(5));
		for (Entity e : listEntity) {			
			Announcement a = new Announcement();
			a.setContent((String) e.getProperty("content"));
			a.setTitle((String) e.getProperty("title"));
			a.setId(KeyFactory.keyToString(e.getKey()));
			listAnnouncement.add(a);
		}
    	
		return listAnnouncement;
    }
    
    
	
	@RequestMapping("admin/announcementHome")
	public ModelAndView announcementHome(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		holder = new AnnouncementDataHolder();
		mav.setViewName("announcement");		
		mav.addObject("form",holder);
					
		holder.setNewsList(getRecentNews());
		mav.setViewName("announcement");
		
		return mav;
	}
	
	@RequestMapping("admin/addNewAnnouncement")
	public ModelAndView addNewAnnouncement(@ModelAttribute("form") AnnouncementDataHolder form, ModelAndView mav) throws EntityNotFoundException{
		
		//Announcement a = new Announcement();
		//a.setContent("Test announcement");
		//a.setTitle("Test only");
		//announcementService.saveAnnouncement(a);
		
		//Key AnnouncementKey = KeyFactory.createKey("Announcement", "BRT-1");
		
		Entity Announcement = new Entity("Announcement");		
		Announcement.setProperty("title", form.getTitle());
		Announcement.setProperty("content", form.getContent());
		
		
		
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		datastore.put(Announcement);		
		try {
			Thread.sleep(5000l);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Announcement a = new Announcement();
		a.setContent((String)Announcement.getProperty("content"));
		a.setTitle((String) Announcement.getProperty("title"));
		a.setId(KeyFactory.keyToString(Announcement.getKey()));
		
		holder.setNewsList(getRecentNews());
		
		
		
		
		//Query query = new Query("Announcement").addSort("title", Query.SortDirection.ASCENDING);
		
		//Query query = new Query("Announcement");//.addFilter("title", FilterOperator.EQUAL, "Dua");
		//query.setFilter(FilterOperator.EQUAL.of("__key__", AnnouncementKey));
		
		
		//List<Entity> Announcements = datastore.prepare(query).asList(FetchOptions.Builder.withLimit(10));
		//System.out.println(Announcements);		
		
		//Entity a = datastore.get(AnnouncementKey);
		//System.out.println(a.getProperties().values().toString());
		
	/*	for(Entity a : Announcements){
			System.out.println("KEY = " + KeyFactory.keyToString(a.getKey()));
		} */
		
		mav.setViewName("announcement");		
		mav.addObject("form",holder);
		return mav;
	}
	
}
