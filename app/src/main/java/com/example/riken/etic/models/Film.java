package com.example.riken.etic.models;

public class Film {

    private String Title;
    private String Genre;
    private String Duration;
    private String Sutradara;
    private int Thumbnails;

    public Film () {

    }

    public Film (String title, String genre, int thumbnails, String duration, String sutradara) {
        Title = title;
        Genre = genre;
        Duration = duration;
        Sutradara = sutradara;
        Thumbnails = thumbnails;
    }

    public String getTitle () {
        return Title;
    }

    public String getGenre () {
        return Genre;
    }

    public String getDuration() { return Duration; }

    public String getSutradara() { return Sutradara; }

    public int getThumbnails() {
        return Thumbnails;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setGenre(String genre) { Genre = genre; }

    public void setDuration(String duration) { Duration = duration; }

    public void setSutradara(String sutradara) { Sutradara = sutradara; }

    public void setThumbnails(int thumbnails) {
        Thumbnails = thumbnails;
    }
}
