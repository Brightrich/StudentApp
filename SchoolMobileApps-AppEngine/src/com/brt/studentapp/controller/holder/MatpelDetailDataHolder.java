package com.brt.studentapp.controller.holder;

import java.util.HashMap;
import com.brt.studentapp.model.Matpel;

public class MatpelDetailDataHolder {
	
	private String matpelDetailClass;
	private String matpelDetailTitle;
	private HashMap<String, String> matpelMap;
	private HashMap<String, Matpel> matpelKeyMap;
	private String matpel;
	private String matpelDetailContent;
	private HashMap<String, String> kelasMap;
	
	
	public HashMap<String, String> getMatpelMap() {
		return matpelMap;
	}

	public void setMatpelMap(HashMap<String, String> matpelMap) {
		this.matpelMap = matpelMap;
	}

	public String getMatpel() {
		return matpel;
	}

	public void setMatpel(String matpel) {
		this.matpel = matpel;
	}

	public String getMatpelDetailClass() {
		return matpelDetailClass;
	}

	public void setMatpelDetailClass(String matpelDetailClass) {
		this.matpelDetailClass = matpelDetailClass;
	}

	public String getMatpelDetailTitle() {
		return matpelDetailTitle;
	}

	public void setMatpelDetailTitle(String matpelDetailTitle) {
		this.matpelDetailTitle = matpelDetailTitle;
	}

	public String getMatpelDetailContent() {
		return matpelDetailContent;
	}

	public void setMatpelDetailContent(String matpelDetailContent) {
		this.matpelDetailContent = matpelDetailContent;
	}

	public HashMap<String, Matpel> getMatpelKeyMap() {
		return matpelKeyMap;
	}

	public void setMatpelKeyMap(HashMap<String, Matpel> matpelKeyMap) {
		this.matpelKeyMap = matpelKeyMap;
	}

	public HashMap<String, String> getKelasMap() {
		return kelasMap;
	}

	public void setKelasMap(HashMap<String, String> kelasMap) {
		this.kelasMap = kelasMap;
	}

	

}
