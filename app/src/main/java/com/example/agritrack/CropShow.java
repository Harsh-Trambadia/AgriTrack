package com.example.agritrack;

import java.util.Date;

public class CropShow {
    private int sno;
    private String crop;
    private String farm;
    private Date fromDate;
    private Date toDate;

    public CropShow(int sno, String crop, String farm, Date fromDate, Date toDate) {
        this.sno = sno;
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

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }


}
