package com.example.parcial2androidecoapp;

public class Score {

    private  String quid;
    private  String score;
    private  String id;

    public Score(String id, String score, String quid) {
        this.id = id;
        this.score = score;
        this.quid = quid;
    }

    public Score(){

    }

    public String getQuid() {
        return quid;
    }

    public void setQuid(String quid) {
        this.quid = quid;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
