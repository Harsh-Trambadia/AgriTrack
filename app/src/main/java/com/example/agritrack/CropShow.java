package com.example.agritrack;

import java.util.Date;

public class CropShow {
    private int sno;
    private String crop;
    private String farm;
    private String fromDate;
    private String toDate;

    public CropShow(int sno, String crop, String farm, String fromDate, String toDate) {

        this.crop = crop;
        this.farm = farm;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
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

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }


}
