package com.example.infomusik;

public class eventDb {

    private String judul;
    private String ket;


    public eventDb(String judul, String ket) {
        this.judul = judul;
        this.ket = ket;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getKet() {
        return ket;
    }

    public void setKet(String ket) {
        this.ket = ket;
    }

    public eventDb() {
    }
}
