package com.example.riken.etic.models;

public class LoginResponse {
    /**
     * status : true
     * access_token : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC8xMjcuMC4wLjE6ODAwMFwvYXBpXC9hdXRoXC9sb2dpbiIsImlhdCI6MTU0MDYyOTI2OCwiZXhwIjoxNTQwNjMyODY4LCJuYmYiOjE1NDA2MjkyNjgsImp0aSI6IjVTaEM4bENJTFJSaTR5Mk8iLCJzdWIiOjQsInBydiI6Ijg3ZTBhZjFlZjlmZDE1ODEyZmRlYzk3MTUzYTE0ZTBiMDQ3NTQ2YWEifQ.nk-JT0wbs1WOXa0-6xA1I1D0hCGUyeoAWG5CvVh_Er8
     * token_type : bearer
     * expires_in : 3600
     */ 

    private boolean status;
    private String access_token;
    private String token_type;
    private int expires_in;

    public LoginResponse(boolean status, String access_token, String token_type, int expires_in) {
        this.status = status;
        this.access_token = access_token;
        this.token_type = token_type;
        this.expires_in = expires_in;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

}
