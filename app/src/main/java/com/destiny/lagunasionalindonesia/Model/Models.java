package com.destiny.lagunasionalindonesia.Model;

public class Models {
    String judul,pencipta,asal,lirik,lagu;

    public Models(){

    }

    public Models(String judul,String pencipta,String asal,String lirik,String lagu){
        this.judul=judul;
        this.pencipta=pencipta;
        this.asal=asal;
        this.lirik=lirik;
        this.lagu=lagu;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPencipta() {
        return pencipta;
    }

    public void setPencipta(String pencipta) {
        this.pencipta = pencipta;
    }

    public String getAsal() {
        return asal;
    }

    public void setAsal(String asal) {
        this.asal = asal;
    }

    public String getLirik() {
        return lirik;
    }

    public void setLirik(String lirik) {
        this.lirik = lirik;
    }

    public String getLagu() {
        return lagu;
    }

    public void setLagu(String lagu) {
        this.lagu = lagu;
    }
}
