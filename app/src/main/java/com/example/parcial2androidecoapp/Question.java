package com.example.parcial2androidecoapp;

public class Question {

    private String id;
    private String description;
    private String isActual;

    public Question(String id, String description, String isActual) {
        this.id = id;
        this.description = description;
        this.isActual = isActual;
    }

    public Question() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsActual() {
        return isActual;
    }

    public void setActual(String actual) {
        isActual = actual;
    }
}
