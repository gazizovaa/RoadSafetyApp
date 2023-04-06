package com.example.roadsafetyapp;

public class RoadModel {
    private String title;
    private int image;

    public RoadModel(String title, int image){
        this.title = title;
        this.image = image;
    }

    public String getTitle(){
        return title;
    }

    public int getImage(){
        return image;
    }
}
