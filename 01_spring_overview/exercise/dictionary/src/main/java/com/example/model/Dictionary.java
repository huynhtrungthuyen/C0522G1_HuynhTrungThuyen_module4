package com.example.model;

public class Dictionary {
    private String eng;
    private String vie;

    public Dictionary() {
    }

    public Dictionary(String eng, String vie) {
        this.eng = eng;
        this.vie = vie;
    }

    public String getEng() {
        return eng;
    }

    public void setEng(String eng) {
        this.eng = eng;
    }

    public String getVie() {
        return vie;
    }

    public void setVie(String vie) {
        this.vie = vie;
    }
}
