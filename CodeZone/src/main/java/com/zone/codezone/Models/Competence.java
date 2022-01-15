package com.zone.codezone.Models;

public class Competence {
    private  String id;
    private  String competence_name;

    public Competence(){

    }
    public Competence( String id,String competence_name) {
        this.setId(id);
        this.setCompetence_name(competence_name);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public String getCompetence_name() {
        return competence_name;
    }

    public void setCompetence_name(String competence_name) {
        this.competence_name = competence_name;
    }
}
