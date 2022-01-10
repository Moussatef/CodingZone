package com.zone.codezone.Models;

public class Question {
    private int  id;
    private String content;
    private int time;
    private int score;
    private Test test;

    public Question(int id, String content, int time, int score, Test test) {
        this.setId(id);
        this.setContent(content);
        this.setTime(time);
        this.setScore(score);
        this.setTest(test);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }
}
