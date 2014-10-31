package com.brt.studentapp.controller.holder;

import java.util.HashMap;

import com.brt.studentapp.model.Kelas;
import com.brt.studentapp.model.Matpel;

public class JadwalPelajaranDataHolder {

	HashMap<String, String> matpelMap;
	HashMap<String, Matpel> matpelKeyMap;
	HashMap<String, String> kelasMap;
	HashMap<String, Kelas> kelasKeyMap;
	private String jadwalHari;
	private String jadwalMulaiJam;
	private String jadwalMulaiMenit;
	private String jadwalSelesaiJam;
	private String jadwalSelesaiMenit;
	private String matpel;
	private String kelas;

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

	public String getJadwalHari() {
		return jadwalHari;
	}

	public void setJadwalHari(String jadwalHari) {
		this.jadwalHari = jadwalHari;
	}

	public String getMatpel() {
		return matpel;
	}

	public void setMatpel(String matpel) {
		this.matpel = matpel;
	}

	public String getJadwalMulaiJam() {
		return jadwalMulaiJam;
	}

	public void setJadwalMulaiJam(String jadwalMulaiJam) {
		this.jadwalMulaiJam = jadwalMulaiJam;
	}

	public String getJadwalMulaiMenit() {
		return jadwalMulaiMenit;
	}

	public void setJadwalMulaiMenit(String jadwalMulaiMenit) {
		this.jadwalMulaiMenit = jadwalMulaiMenit;
	}

	public String getJadwalSelesaiJam() {
		return jadwalSelesaiJam;
	}

	public void setJadwalSelesaiJam(String jadwalSelesaiJam) {
		this.jadwalSelesaiJam = jadwalSelesaiJam;
	}

	public String getJadwalSelesaiMenit() {
		return jadwalSelesaiMenit;
	}

	public void setJadwalSelesaiMenit(String jadwalSelesaiMenit) {
		this.jadwalSelesaiMenit = jadwalSelesaiMenit;
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

	public String getKelas() {
		return kelas;
	}

	public void setKelas(String kelas) {
		this.kelas = kelas;
	}
	
	
}
