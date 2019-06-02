package com.example.myapplication.ApiClass;

public class Service {
    private String OperatorCode;

    private String Name;

    private String Logo;

    public String getOperatorCode() {
        return OperatorCode;
    }

    public void setOperatorCode(String operatorCode) {
        OperatorCode = operatorCode;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLogo() {
        return Logo;
    }

    public void setLogo(String logo) {
        Logo = logo;
    }

    @Override
    public String toString() {
        return "Service{" +
                "OperatorCode='" + OperatorCode + '\'' +
                ", Name='" + Name + '\'' +
                ", Logo='" + Logo + '\'' +
                '}';
    }
}
