package com.example.infomusik;

public class blog {

    private String foto;
    private String info;


    public blog(String foto, String info) {
        this.foto = foto;
        this.info = info;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public blog() {
    }
}
