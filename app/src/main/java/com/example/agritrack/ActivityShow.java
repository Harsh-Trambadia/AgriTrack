package com.example.agritrack;

import java.util.Date;

public class ActivityShow {
    private int sno;
    private String actName;
    private String crop;
    private String farm;
    private Date date;

    public ActivityShow(int sno, String actName, String crop, String farm, Date date) {
        this.sno = sno;
        this.actName = actName;
        this.crop = crop;
        this.farm = farm;
        this.date = date;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getActName() {
        return actName;
    }

    public void setActName(String actName) {
        this.actName = actName;
    }

    public String getCrop() {
        return crop;
    }

    public void setCrop(String crop) {
        this.crop = crop;
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
