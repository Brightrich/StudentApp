package com.brt.studentapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Text;

@Entity
public class MatpelDetail {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Key key;
	private String Kelas;
	private String Title;
	private Text Content;
	
	public Key getKey() {
		return key;
	}
	public void setKey(Key key) {
		this.key = key;
	}
	public String getKelas() {
		return Kelas;
	}
	public void setKelas(String kelas) {
		Kelas = kelas;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public Text getContent() {
		return Content;
	}
	public void setContent(Text content) {
		Content = content;
	}

	
	
}
