package com.example.agritrack;



public class FarmShow {
    private int sno;
    private String farm;
    private String date;

    public FarmShow(int sno, String farm, String date) {

        this.farm = farm;
        this.date = date;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getFarm() {
        return farm;
    }

    public void setFarm(String farm) {
        this.farm = farm;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
