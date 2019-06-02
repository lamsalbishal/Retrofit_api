package com.example.myapplication.ApiClass;

public class Safari {

    private String _id;
    private String title;
    private String description;
    private String image;

    public Safari(String title, String description, String image) {
        this.title = title;
        this.description = description;
        this.image = image;
    }

    public String get_id() {
        return _id;
    }
}
