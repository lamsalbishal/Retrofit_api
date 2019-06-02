package com.example.myapplication.ApiClass;

public class Service {
    private String OperatorCode;

    private String Name;


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

    @Override
    public String toString() {
        return "Service{" +
                "OperatorCode='" + OperatorCode + '\'' +
                ", Name='" + Name + '\'' +
                '}';
    }
}
