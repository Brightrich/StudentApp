package com.brt.studentapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Blob;
import com.google.appengine.api.datastore.Key;

@Entity
public class Staff {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Key key;
	private String Name;
	private String Jabatan;
	private Blob Photo;
	
	public Key getKey() {
		return key;
	}
	public void setKey(Key key) {
		this.key = key;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getJabatan() {
		return Jabatan;
	}
	public void setJabatan(String jabatan) {
		Jabatan = jabatan;
	}
	public Blob getPhoto() {
		return Photo;
	}
	public void setPhoto(Blob photo) {
		Photo = photo;
	}
	
	
	
}
