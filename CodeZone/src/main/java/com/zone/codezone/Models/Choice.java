package com.zone.codezone.Models;

public class Choice {
    private int  id;
    private String content;
    private boolean isCorrect;
    //private Question question;

    public Choice(int id, String content, boolean isCorrect) {
        this.setId(id);
        this.setContent( content);
        this.setCorrect(isCorrect);
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

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
}
