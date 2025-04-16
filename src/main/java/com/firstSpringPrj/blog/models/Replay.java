package com.firstSpringPrj.blog.models;

import org.springframework.data.annotation.Id;

public class Replay {
    @Id
    public String id;
    public String fullText;

    public Replay(String fullTextl) {
        this.fullText = fullTextl;
    }

    public Replay() {
    }
}
