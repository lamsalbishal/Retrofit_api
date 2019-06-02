package com.example.myapplication.ApiClass;

import java.util.ArrayList;

public class Prabhu {
    private String Code;

    private String Message;


    private ArrayList<Services> Services;


    private String UserName;

    private String Password;





    public Prabhu(String userName, String password) {
        UserName = userName;
        Password = password;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }


    public ArrayList<com.example.myapplication.ApiClass.Services> getServices() {
        return Services;
    }

    public void setServices(ArrayList<com.example.myapplication.ApiClass.Services> services) {
        Services = services;
    }
}
