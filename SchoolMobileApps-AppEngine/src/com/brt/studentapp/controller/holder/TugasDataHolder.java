package com.brt.studentapp.controller.holder;

import java.util.HashMap;

import org.springframework.web.multipart.MultipartFile;

import com.brt.studentapp.model.Matpel;

public class TugasDataHolder {

	private String tugasClass;
	private String tugasTitle;
	private HashMap<String, String> matpelMap;
	private HashMap<String, Matpel> matpelKeyMap;
	private HashMap<String, String> kelasMap;	
	private String matpel;
	private MultipartFile tugasFile;
	private String extension;
	
	public String getTugasClass() {
		return tugasClass;
	}
	public void setTugasClass(String tugasClass) {
		this.tugasClass = tugasClass;
	}
	public String getTugasTitle() {
		return tugasTitle;
	}
	public void setTugasTitle(String tugasTitle) {
		this.tugasTitle = tugasTitle;
	}
	public HashMap<String, String> getMatpelMap() {
		return matpelMap;
	}
	public void setMatpelMap(HashMap<String, String> matpelMap) {
		this.matpelMap = matpelMap;
	}
	public HashMap<String, Matpel> getMatpelKeyMap() {
		return matpelKeyMap;
	}
	public void setMatpelKeyMap(HashMap<String, Matpel> matpelKeyMap) {
		this.matpelKeyMap = matpelKeyMap;
	}
	public String getMatpel() {
		return matpel;
	}
	public void setMatpel(String matpel) {
		this.matpel = matpel;
	}
	public MultipartFile getTugasFile() {
		return tugasFile;
	}
	public void setTugasFile(MultipartFile tugasFile) {
		this.tugasFile = tugasFile;
	}
	public HashMap<String, String> getKelasMap() {
		return kelasMap;
	}
	public void setKelasMap(HashMap<String, String> kelasMap) {
		this.kelasMap = kelasMap;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}	
	
	
}
