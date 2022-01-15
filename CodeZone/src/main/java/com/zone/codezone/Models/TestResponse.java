package com.zone.codezone.Models;

public class TestResponse {

    private Test test;
    private String  id;
    private TestCandidat testCondidat;
    private  Question question;
    private Choice choice;
    private int timerResponse;



    public TestResponse(String id,Question question, Choice choice, int timerResponse,TestCandidat testCondidat) {
        this.setId( id);
        this.setChoice( choice);
        this.setTimerResponse(timerResponse);
        this.setQuestion(question);
        this.setTestCandidate(testCondidat);
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
    public Test getTest() {
        return test;
    }
    public void setQuestion(Question question) {
        this.question = question;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public TestCandidat getTestCandidate() {
        return testCondidat;
    }

    public void setTestCandidate(TestCandidat testCondidat) {
        this.testCondidat = testCondidat;
    }
}
