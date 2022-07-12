package com.example.agritrack;

import java.util.Date;

public class FarmShow {
    private int sno;
    private String farm;
    private Date date;

    public FarmShow(int sno, String farm, Date date) {
        this.sno = sno;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
