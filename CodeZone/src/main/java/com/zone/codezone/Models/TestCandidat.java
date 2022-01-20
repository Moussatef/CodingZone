package com.zone.codezone.Models;

public class TestCandidat {
    private String id;
    private String candidat_code;
    private Test test;
    private Learner learner;
    private boolean isClosed;

    public TestCandidat() {}

    public TestCandidat(String id, String candidate_code, Test test, Learner learner,boolean isClosed) {
        this.setId(id);
        this.setCandidat_code(candidate_code);
        this.setTest(test);
        this.setLearner(learner);
        this.setClosed(isClosed);
    }
    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
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
