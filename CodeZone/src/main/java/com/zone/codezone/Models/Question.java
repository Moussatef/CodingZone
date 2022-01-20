package com.zone.codezone.Models;

public class Question {
    private String id;
    private String content;
    private int time ;
    private double score;
    private Test test;



    public Question(String id, String content, int time, double score,Test test) {
//, Test test
        this.setId(id);
        this.setContent(content);
        this.setTime(time);
        this.setScore(score);
        this.setTest(test);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }
}
