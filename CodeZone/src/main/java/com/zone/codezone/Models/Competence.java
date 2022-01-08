package com.zone.codezone.Models;

public class Competence {
    private  int id;
    private  String competence_name;
    public Competence( String competence_name) {
        this.setCompetence_name(competence_name);
    }

    public int getId() {
        return id;
    }



    public String getCompetence_name() {
        return competence_name;
    }

    public void setCompetence_name(String competence_name) {
        this.competence_name = competence_name;
    }
}
