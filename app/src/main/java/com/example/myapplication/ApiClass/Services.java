package com.example.myapplication.ApiClass;

import java.util.ArrayList;

public class Services {
    private String Category;

    private ArrayList<Service> Service;



    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public ArrayList<com.example.myapplication.ApiClass.Service> getService() {
        return Service;
    }

    public void setService(ArrayList<com.example.myapplication.ApiClass.Service> service) {
        Service = service;
    }

    @Override
    public String toString() {
        return "Services{" +
                "Category='" + Category + '\'' +
                ", Service=" + Service +
                '}';
    }
}
