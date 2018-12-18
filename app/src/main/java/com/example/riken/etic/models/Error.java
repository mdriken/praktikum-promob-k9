package com.example.riken.etic.models;

import java.util.List;

public class Error{
	private List<String> password;
	private List<String> name;
	private List<String> email;
	private List<String> tanggalLahir;

	public void setPassword(List<String> password){
		this.password = password;
	}

	public List<String> getPassword(){
		return password;
	}

	public void setName(List<String> name){
		this.name = name;
	}

	public List<String> getName(){
		return name;
	}

	public void setEmail(List<String> email){
		this.email = email;
	}

	public List<String> getEmail(){
		return email;
	}

	public void setTanggalLahir(List<String> tanggalLahir){
		this.tanggalLahir = tanggalLahir;
	}

	public List<String> getTanggalLahir(){
		return tanggalLahir;
	}

	@Override
 	public String toString(){
		return 
			"Error{" + 
			"password = '" + password + '\'' + 
			",name = '" + name + '\'' + 
			",email = '" + email + '\'' + 
			",tanggal_lahir = '" + tanggalLahir + '\'' + 
			"}";
		}
}