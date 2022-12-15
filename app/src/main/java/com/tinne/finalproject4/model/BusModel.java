package com.tinne.finalproject4.model;

public class BusModel {
    private String namaBus;
    private String kodeBus;
    private int image;
    private String darimana;
    private String kemana;
    private String jamKemana;
    private String jamDarimana;
    private int harga;


    public BusModel(String namaBus, String kodeBus, int image, String darimana, String kemana, String jamKemana, String jamDarimana, int harga) {
        this.namaBus = namaBus;
        this.kodeBus = kodeBus;
        this.image = image;
        this.darimana = darimana;
        this.kemana = kemana;
        this.jamKemana = jamKemana;
        this.jamDarimana = jamDarimana;
        this.harga = harga;
    }


    public String getNamaBus() {
        return namaBus;
    }

    public void setNamaBus(String namaBus) {
        this.namaBus = namaBus;
    }

    public String getKodeBus() {
        return kodeBus;
    }

    public void setKodeBus(String kodeBus) {
        this.kodeBus = kodeBus;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDarimana() {
        return darimana;
    }

    public void setDarimana(String darimana) {
        this.darimana = darimana;
    }

    public String getKemana() {
        return kemana;
    }

    public void setKemana(String kemana) {
        this.kemana = kemana;
    }

    public String getJamKemana() {
        return jamKemana;
    }

    public void setJamKemana(String jamKemana) {
        this.jamKemana = jamKemana;
    }

    public String getJamDarimana() {
        return jamDarimana;
    }

    public void setJamDarimana(String jamDarimana) {
        this.jamDarimana = jamDarimana;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
}
