package com.zone.codezone.Models;

public class Learner {
    private String  id;
    private String firstName;
    private String lastName;
    private String email;
    private ClassLearner classLearner;



    public Learner() {

    }

    public Learner(String id, String firstName, String lastName, String email, ClassLearner classLearner) {
        this.setId(id);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setEmail(email);
        this.setClassLearner(classLearner);
    }

    public ClassLearner getClassLearner() {
        return classLearner;
    }

    public void setClassLearner(ClassLearner classLearner) {
        this.classLearner = classLearner;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
