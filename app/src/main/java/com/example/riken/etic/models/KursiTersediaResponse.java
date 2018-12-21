package com.example.riken.etic.models;


import com.google.gson.annotations.SerializedName;


public class KursiTersediaResponse{

	@SerializedName("kode_kursi")
	private String kodeKursi;

	public void setKodeKursi(String kodeKursi){
		this.kodeKursi = kodeKursi;
	}

	public String getKodeKursi(){
		return kodeKursi;
	}

	@Override
 	public String toString(){
		return 
			"KursiTersediaResponse{" + 
			"kode_kursi = '" + kodeKursi + '\'' + 
			"}";
		}
}