package com.example.myapplication.ApiClass;

import java.util.ArrayList;

public class NeaOfficeCode {

    private String Code;

    private String Message;

    private ArrayList<OfficeCodes> OfficeCodes;

    private String UserName;

    private String Password;

    public NeaOfficeCode(String userName, String password) {
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

    public ArrayList<OfficeCodes> getOfficeCodes() {
        return OfficeCodes;
    }

    public void setOfficeCodes(ArrayList<OfficeCodes> officeCodes) {
        this.OfficeCodes = officeCodes;
    }

    @Override
    public String toString() {
        return "NeaOfficeCode{" +
                "Code='" + Code + '\'' +
                ", Message='" + Message + '\'' +
                ", officeCodes=" + OfficeCodes +
                '}';
    }
}
