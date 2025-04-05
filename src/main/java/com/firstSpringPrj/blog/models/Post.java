package com.firstSpringPrj.blog.models;

import org.springframework.data.annotation.Id;


public class Post {
    @Id
    public String id;
    public String title,anons,full_text;
    public int views;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlows() {
        return anons;
    }

    public void setAlows(String alows) {
        this.anons = alows;
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



    public Post(String title, String anons, String full_text) {
        this.title = title;
        this.anons = anons;
        this.full_text = full_text;
        this.views = 0;
    }

    public Post() {
    }
}
