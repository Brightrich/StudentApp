package com.brt.studentapp.controller.holder;

import org.springframework.web.multipart.MultipartFile;

public class StaffDataHolder {

	private String staffNIK;
	private String staffName;
	private String staffRole;
	private MultipartFile staffPhoto;
	

	public MultipartFile getStaffPhoto() {
		return staffPhoto;
	}
	public void setStaffPhoto(MultipartFile staffPhoto) {
		this.staffPhoto = staffPhoto;
	}
	public String getStaffNIK() {
		return staffNIK;
	}
	public void setStaffNIK(String staffNIK) {
		this.staffNIK = staffNIK;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getStaffRole() {
		return staffRole;
	}
	public void setStaffRole(String staffRole) {
		this.staffRole = staffRole;
	}
	

}
