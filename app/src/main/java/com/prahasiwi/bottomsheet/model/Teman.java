package com.prahasiwi.bottomsheet.model;

public class Teman {
    private String nama;
    private String lokasi;
    private String waktu;

    public Teman(String nama, String lokasi, String waktu) {
        this.nama = nama;
        this.lokasi = lokasi;
        this.waktu = waktu;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }
}
