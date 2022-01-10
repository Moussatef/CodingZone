package com.zone.codezone.Models;

public class TestCandidat {
    private String id;
    private String candidat_code;
    private Test test;
    private Learner learner;

    public TestCandidat() {
    }

    public TestCandidat(String id, String candidat_code, Test test, Learner learner) {
        this.setId(id);
        this.setCandidat_code(candidat_code);
        this.setTest(test);
        this.setLearner(learner);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCandidat_code() {
        return candidat_code;
    }

    public void setCandidat_code(String candidat_code) {
        this.candidat_code = candidat_code;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public Learner getLearner() {
        return learner;
    }

    public void setLearner(Learner learner) {
        this.learner = learner;
    }
}
