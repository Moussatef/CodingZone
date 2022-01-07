package com.zone.codezone.Models;

public class Question {
    private long id;
    private String content;

    private String time ;
    private int score;
    //private Test test;

    public Question(long id, String content, String time, int score) {
        this.id = 29L;
        this.setContent(content);
        this.setTime(time);
        this.setScore(score);
    }


    public long getId() {
        return id;
    }



    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}