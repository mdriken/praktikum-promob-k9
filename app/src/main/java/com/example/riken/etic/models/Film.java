package com.example.riken.etic.models;

public class Film {

    private String Title;
    private String Genre;
    private int Thumbnails;

    public Film () {

    }

    public Film (String title, String genre, int thumbnails) {
        Title = title;
        Genre = genre;
        Thumbnails = thumbnails;
    }

    public String getTitle () {
        return Title;
    }

    public String getGenre () {
        return Genre;
    }

    public int getThumbnails() {
        return Thumbnails;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public void setThumbnails(int thumbnails) {
        Thumbnails = thumbnails;
    }
}
