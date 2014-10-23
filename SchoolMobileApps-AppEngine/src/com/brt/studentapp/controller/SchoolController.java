package com.brt.studentapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.brt.studentapp.controller.holder.SchoolDataHolder;
import com.brt.studentapp.model.Page;
import com.brt.studentapp.model.PageEndpoint;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Text;

@Controller
public class SchoolController {
	
	SchoolDataHolder holder;
	
	@RequestMapping("admin/schoolHome")
	public ModelAndView schoolHome (HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		holder = new SchoolDataHolder();
		mav.setViewName("school");
		mav.addObject("form", holder);
		return mav;
	}
	 
	
	@RequestMapping("admin/addSchool")
	public ModelAndView addSchool (@ModelAttribute("form") SchoolDataHolder form, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		Page p = new Page();
		Key k = KeyFactory.createKey("Page", "Sejarah");
		System.out.println("KEY ID (LONG) = " + k.getId());
		p.setKey(k);
		Text t = new Text(form.getPage());
		p.setContent(t);
		PageEndpoint pe = new PageEndpoint();
		pe.insertPage(p);
		
		
		//Key PageKey = KeyFactory.createKey("Page", "IPA");
		//Entity page = new Entity("Page", "Sejarah");		
		
		//page.setProperty("content", t);		
		//DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		///datastore.put(page);
		
		//Query query = new Query ("Page");
		//try {
			//Entity e = datastore.get(KeyFactory.createKey("Page", "Sejarah"));
		    
			//Page pquery = pe.getPageByKey(KeyFactory.createKey("Page", "Sejarah"));
			//Text queryText = (Text) e.getProperty("content");
			//System.out.println(queryText.getValue());
			//System.out.println(pquery.getContent());
		//} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		
		
		//List<Entity> Pages = datastore.prepare(query).asList(FetchOptions.Builder.withLimit(1));
		//Text queryText = (Text) Pages.get(0).getProperty("content");
		
		//System.out.println(queryText.getValue());		
		
		/*PrintWriter writer;
		try {
			File f = new File(request.getSession().
					getServletContext().getRealPath("/WEB-INF/"),"/sejarah.html");
			writer = new PrintWriter(f);
			writer.println(form.getPage().trim());		
			writer.close();
		} catch (Exception e) {			
			e.printStackTrace();
		}
				
		//File fileNew = new File(request.getSession().
		//		getServletContext().getRealPath("/WEB-INF/"), file.getOriginalFilename());
*/		//System.out.println("isi = " + form.getPage());
		mav.setViewName("school");
		return mav;
	}
}
