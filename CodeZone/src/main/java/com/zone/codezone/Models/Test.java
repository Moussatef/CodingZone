package com.zone.codezone.Models;

import java.sql.Date;

public class Test {
    private int id;
    private String title;
    private Date start_date;
    private Date end_date;
    // private Competance competance;


    public Test(int id, String title, Date start_date, Date end_date) {
        this.setId(id);
        this.setTitle(title);
        this.setStart_date(start_date);
        this.setEnd_date(end_date);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }
}
