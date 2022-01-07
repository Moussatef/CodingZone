package com.zone.codezone.Models;

public class Class {

    private int id;
    private String class_name;

    public Class(String class_name) {
        this.setClass_name(class_name);
    }

    public int getId() {
        return id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }
}
