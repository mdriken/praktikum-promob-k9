package com.example.riken.etic.models;


import com.google.gson.annotations.SerializedName;


public class KursiTersediaResponse{

	@SerializedName("kode_kursi")
	private String kodeKursi;

	@SerializedName("id")
	private int id;

	public void setKodeKursi(String kodeKursi){
		this.kodeKursi = kodeKursi;
	}

	public String getKodeKursi(){
		return kodeKursi;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"KursiTersediaResponse{" + 
			"kode_kursi = '" + kodeKursi + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}