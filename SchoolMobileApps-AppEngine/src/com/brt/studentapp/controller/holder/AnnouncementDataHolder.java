package com.brt.studentapp.controller.holder;

import java.util.List;

import com.brt.studentapp.model.Announcement;

public class AnnouncementDataHolder {

	private String id;
	private String title;
	private String content;
	private List<Announcement> newsList;
	private String title_search;
	private String deleteId;
	
	public String getTitle_search() {
		return title_search;
	}
	public void setTitle_search(String title_search) {
		this.title_search = title_search;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public List<Announcement> getNewsList() {
		return newsList;
	}
	public void setNewsList(List<Announcement> newsList) {
		this.newsList = newsList;
	}
	public String getDeleteId() {
		return deleteId;
	}
	public void setDeleteId(String deleteId) {
		this.deleteId = deleteId;
	}
	
	
	
	
}
