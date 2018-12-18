package com.example.riken.etic.models;

public class NewLoginResponse{
	private String msg;
	private String access_token;
	private Error error;
	private boolean status;

	public NewLoginResponse(String access_token) {
		this.access_token = access_token;

	}

	public void setMsg(String msg){
		this.msg = msg;
	}

	public String getMsg(){
		return msg;
	}

	public void setAccessToken(String accessToken){
		this.access_token = accessToken;
	}

	public String getAccessToken(){
		return access_token;
	}

	public void setError(Error error){
		this.error = error;
	}

	public Error getError(){
		return error;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"NewLoginResponse{" + 
			"msg = '" + msg + '\'' + 
			",access_token = '" + access_token + '\'' +
			",error = '" + error + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}
