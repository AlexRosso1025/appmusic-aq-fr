package com.co.poli.appmusicaqfr.appmusic.model;

import java.util.ArrayList;

public class ReproductionList {
    private String name;
    private String description;
    private ArrayList<Song> songs;

    public ReproductionList() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }
}
