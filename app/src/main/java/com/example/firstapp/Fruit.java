package com.example.firstapp;

public class Fruit {
    private String name;
    private int imagineId;
    public Fruit(String name,int imagineId){
        this.name = name;
        this.imagineId = imagineId;
    }

    public String getName() {
        return name;
    }

    public int getImagineId() {
        return imagineId;
    }
}
