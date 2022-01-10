package com.zone.codezone.Models;

public class TestResponse {

    private Test test;
    private String  id;
    //private TestCondidat testCondidat;
    private  Question question;
    private Choice choice;
    private int timerResponse;

    public void setQuestion(Question question) {
        this.question = question;
    }

    public TestResponse(String id, Choice choice, int timerResponse) {
        this.setId( id);
        this.setChoice( choice);
        this.setTimerResponse(timerResponse);
        this.setQuestion(question);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public Question getQuestion() {
        return question;
    }
}
