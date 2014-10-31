package com.brt.studentapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;

@Entity
public class JadwalPelajaran {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Key key;
	private String kelas;
	private String hari;
	private String jamMulai;
	private String jamSelesai;
	private String matpelName;
	
	public Key getKey() {
		return key;
	}
	public void setKey(Key key) {
		this.key = key;
	}
	public String getKelas() {
		return kelas;
	}
	public void setKelas(String kelas) {
		this.kelas = kelas;
	}
	public String getHari() {
		return hari;
	}
	public void setHari(String hari) {
		this.hari = hari;
	}
	public String getMatpelName() {
		return matpelName;
	}
	public void setMatpelName(String matpelName) {
		this.matpelName = matpelName;
	}
	public String getJamMulai() {
		return jamMulai;
	}
	public void setJamMulai(String jamMulai) {
		this.jamMulai = jamMulai;
	}
	public String getJamSelesai() {
		return jamSelesai;
	}
	public void setJamSelesai(String jamSelesai) {
		this.jamSelesai = jamSelesai;
	}
	
	
}
