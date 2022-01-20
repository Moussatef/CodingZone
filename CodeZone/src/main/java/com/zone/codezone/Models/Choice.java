package com.zone.codezone.Models;

public class Choice {
    private String  id;
    private String content;
    private boolean isCorrect;
    private Question question;

    public Choice(String id, String content, boolean isCorrect,Question question) {
        this.setId(id);
        this.setContent( content);
        this.setCorrect(isCorrect);
        this.setQuestion(question);
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

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
