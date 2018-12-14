package com.example.riken.etic.models;

public class Jadwal {

    private String BioskopNamre;
    private String Harga;

    public Jadwal() {

}

public Jadwal (String bioskopNamre, String harga) {
        BioskopNamre = bioskopNamre;
        Harga = harga;
}

    public String getBioskopNamre() {
        return BioskopNamre;
    }

    public String getHarga() {
        return Harga;
    }

    public void setBioskopNamre(String bioskopNamre) {
        BioskopNamre = bioskopNamre;
    }

    public void setHarga(String harga) {
        Harga = harga;
    }
}
