package com.example.riken.etic.models;


import com.google.gson.annotations.SerializedName;


public class InsertResponse{

	@SerializedName("msg")
	private String msg;

	public void setMsg(String msg){
		this.msg = msg;
	}

	public String getMsg(){
		return msg;
	}

	@Override
 	public String toString(){
		return 
			"InsertResponse{" + 
			"msg = '" + msg + '\'' + 
			"}";
		}
}