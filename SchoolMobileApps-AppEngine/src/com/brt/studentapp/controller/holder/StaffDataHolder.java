package com.brt.studentapp.controller.holder;

import java.util.HashMap;

import org.springframework.web.multipart.MultipartFile;

import com.brt.studentapp.model.Kelas;

public class StaffDataHolder {

	private String staffNIK;
	private String staffName;
	private String staffRole;
	private MultipartFile staffPhoto;
	
	private String studentNIS;
	private String studentFirstName;
	private String studentLastName;
	private String studentEmail;
	private String studentPhone;
	private String studentIMSI;
	private MultipartFile studentPhoto;
	private String kelas;
	HashMap<String, String> kelasMap;
	HashMap<String, Kelas> kelasKeyMap;
	
	

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
	public String getStudentNIS() {
		return studentNIS;
	}
	public void setStudentNIS(String studentNIS) {
		this.studentNIS = studentNIS;
	}
	public String getStudentFirstName() {
		return studentFirstName;
	}
	public void setStudentFirstName(String studentFirstName) {
		this.studentFirstName = studentFirstName;
	}
	public String getStudentLastName() {
		return studentLastName;
	}
	public void setStudentLastName(String studentLastName) {
		this.studentLastName = studentLastName;
	}
	public String getStudentEmail() {
		return studentEmail;
	}
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
	public String getStudentPhone() {
		return studentPhone;
	}
	public void setStudentPhone(String studentPhone) {
		this.studentPhone = studentPhone;
	}
	public String getStudentIMSI() {
		return studentIMSI;
	}
	public void setStudentIMSI(String studentIMSI) {
		this.studentIMSI = studentIMSI;
	}
	public MultipartFile getStudentPhoto() {
		return studentPhoto;
	}
	public void setStudentPhoto(MultipartFile studentPhoto) {
		this.studentPhoto = studentPhoto;
	}
	public String getKelas() {
		return kelas;
	}
	public void setKelas(String kelas) {
		this.kelas = kelas;
	}
	public HashMap<String, String> getKelasMap() {
		return kelasMap;
	}
	public void setKelasMap(HashMap<String, String> kelasMap) {
		this.kelasMap = kelasMap;
	}
	public HashMap<String, Kelas> getKelasKeyMap() {
		return kelasKeyMap;
	}
	public void setKelasKeyMap(HashMap<String, Kelas> kelasKeyMap) {
		this.kelasKeyMap = kelasKeyMap;
	}
	

}
