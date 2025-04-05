package com.firstSpringPrj.blog.models;

import org.springframework.data.annotation.Id;

public class Post {
    private String title,alows,full_text;
    private int views;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlows() {
        return alows;
    }

    public void setAlows(String alows) {
        this.alows = alows;
    }

    public String getFull_text() {
        return full_text;
    }

    public void setFull_text(String full_text) {
        this.full_text = full_text;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }



    public Post(String title, String alows, String full_text, int views) {
        this.title = title;
        this.alows = alows;
        this.full_text = full_text;
        this.views = views;
    }

    public Post() {
    }
}
