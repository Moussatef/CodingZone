package com.zone.codezone.Models;

public class ClassLearner {

    private String id;

    public void setId(String id) {
        this.id = id;
    }

    private String class_name;

    public ClassLearner(String id,String class_name) {
        this.setId(id);
        this.setClass_name(class_name);
    }

    public String  getId() {
        return id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }
}
