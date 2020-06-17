package com.pojtinger.felix.hdm.seOne.jtodo.backend;

import java.util.UUID;

public class Todo {
    private String id;
    private String title;
    private String body;

    public Todo(String id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Todo(String title, String body) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.body = body;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getBody() {
        return this.body;
    }
}