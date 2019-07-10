package com.destiny.lagunasionalindonesia.Model;

public class Models {
    String judul,pencipta,asal,lirik,lagu;
    String no,soal,jawaban,jawabana,jawabanb,jawabanc,jawaband;

    public Models(){

    }

    public Models(String judul,String pencipta,String asal,String lirik,String lagu){
        this.judul=judul;
        this.pencipta=pencipta;
        this.asal=asal;
        this.lirik=lirik;
        this.lagu=lagu;
    }

    public Models(String no,String soal,String jawaban,String jawabana,String jawabanb,String jawabanc,String jawaband){
        this.no=no;
        this.soal=soal;
        this.jawaban=jawaban;
        this.jawabana=jawabana;
        this.jawabanb=jawabanb;
        this.jawabanc=jawabanc;
        this.jawaband=jawaband;
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

    public String getSoal() {
        return soal;
    }

    public void setSoal(String soal) {
        this.soal = soal;
    }

    public String getJawaban() {
        return jawaban;
    }

    public void setJawaban(String jawaban) {
        this.jawaban = jawaban;
    }

    public String getJawabana() {
        return jawabana;
    }

    public void setJawabana(String jawabana) {
        this.jawabana = jawabana;
    }

    public String getJawabanb() {
        return jawabanb;
    }

    public void setJawabanb(String jawabanb) {
        this.jawabanb = jawabanb;
    }

    public String getJawabanc() {
        return jawabanc;
    }

    public void setJawabanc(String jawabanc) {
        this.jawabanc = jawabanc;
    }

    public String getJawaband() {
        return jawaband;
    }

    public void setJawaband(String jawaband) {
        this.jawaband = jawaband;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }
}
