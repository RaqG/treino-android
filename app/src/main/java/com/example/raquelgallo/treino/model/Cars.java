package com.example.raquelgallo.treino.model;

import com.example.raquelgallo.treino.R;

/**
 * Created by Raquel Gallo on 17/12/2017.
 */

public class Cars {

    private int id;
    private String brand;
    private String model;
    private int year;
    private String color;

    public Cars(int id, String brand, String model, int year, String color) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCarImg(int position) {
        switch (position) {
            case 0:
                return R.mipmap.audi;
            case 1:
                return R.mipmap.bmw;
            case 2:
                return R.mipmap.ferrari;
            case 3:
                return R.mipmap.lamborghini;
            default:
                return R.mipmap.ic_launcher_round;
        }
    }
}