package com.example.infomusik;

public class eventDb {

    private String foto;
    private String info;
    private String desc;

    public eventDb(String foto, String info, String desc) {
        this.foto = foto;
        this.info = info;
        this.desc = desc;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }



    public eventDb() {
    }
}
