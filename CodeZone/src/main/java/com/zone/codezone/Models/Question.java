package com.zone.codezone.Models;

public class Question {
    private String id;
    private String content;
    private int time ;
    private float score;
    //private Test test;

    public Question(String id, String content, int time, float score) {
        this.id = id;
        this.setContent(content);
        this.setTime(time);
        this.setScore(score);
    }


    public String getId() {
        return id;
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

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}