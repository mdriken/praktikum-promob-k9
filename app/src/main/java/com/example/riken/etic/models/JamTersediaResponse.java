package com.example.riken.etic.models;


import com.google.gson.annotations.SerializedName;


public class JamTersediaResponse{

	@SerializedName("jam_mulai")
	private String jamMulai;

	@SerializedName("id")
	private int id;

	public void setJamMulai(String jamMulai){
		this.jamMulai = jamMulai;
	}

	public String getJamMulai(){
		return jamMulai;
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
			"JamTersediaResponse{" + 
			"jam_mulai = '" + jamMulai + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}