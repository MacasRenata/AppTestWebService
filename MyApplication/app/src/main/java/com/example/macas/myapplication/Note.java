package com.example.macas.myapplication;

/**
 * Created by macas on 14/12/17.
 */

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;



public class Note implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final String DATE_FORMAT = "yyyy/MM/dd HH:mm:ss";

    private Long id;
    private Date date;
    private String title;
    private String text;

    public Note() {
        this(new Date(), null, null);
    }

    public Note(Date date, String title, String text) {
        this(null, date, title, text);
    }

    public Note(Long id, Date date, String title, String text) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDateString() {
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);

        return format.format(this.getDate());
    }

    public void setDateString(String date) {
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
    }

    @Override
    public String toString() {
        return getTitle();
    }




}
