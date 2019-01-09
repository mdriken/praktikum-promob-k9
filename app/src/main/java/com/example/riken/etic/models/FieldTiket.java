package com.example.riken.etic.models;

public class FieldTiket {
    private String nama_film;
    private String bioskop;
    private String seat;
    private String jam;
    private String tanggal;
    private String status;

    public FieldTiket(String _nama_film, String _bioskop, String _seat, String _jam, String _tanggal, String _status) {
        this.setNama_film(_nama_film);
        this.setBioskop(_bioskop);
        this.setSeat(_seat);
        this.setJam(_jam);
        this.setTanggal(_tanggal);
        this.setStatus(_status);

    }


    public String getNama_film() {
        return nama_film;
    }

    public void setNama_film(String nama_film) {
        this.nama_film = nama_film;
    }

    public String getBioskop() {
        return bioskop;
    }

    public void setBioskop(String bioskop) {
        this.bioskop = bioskop;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
