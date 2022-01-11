package com.zone.codezone.Models;

public class TestResponse {

    private Test test;
    private String  id;
    private TestCandidat testCondidat;
    private  Question question;
    private Choice choice;
    private int timerResponse;



    public TestResponse(String id, Choice choice, int timerResponse,Test test,TestCandidat testCondidat) {
        this.setId( id);
        this.setChoice( choice);
        this.setTimerResponse(timerResponse);
        this.setQuestion(question);
        this.setTest(test);
        this.setTestCondidat(testCondidat);
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

    public TestCandidat getTestCondidat() {
        return testCondidat;
    }

    public void setTestCondidat(TestCandidat testCondidat) {
        this.testCondidat = testCondidat;
    }
}
