package com.zone.codezone.Models;

public class TestResponse {
    private int  id;
    //private TestCondidat testCondidat;
   // private  Question question;
    private Choice choice;
    private int timerResponse;


    public TestResponse(int id, Choice choice, int timerResponse) {
        this.setId( id);
        this.setChoice( choice);
        this.setTimerResponse(timerResponse);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Choice getChoice() {
        return choice;
    }

    public void setChoice(Choice choice) {
        this.choice = choice;
    }

    public int getTimerResponse() {
        return timerResponse;
    }

    public void setTimerResponse(int timerResponse) {
        this.timerResponse = timerResponse;
    }




}
