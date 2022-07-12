package com.example.agritrack;

public class ExpenseShow{
    public ExpenseShow( int sno, String actname, int value) {

        this.Actname = actname;
        this.value = value;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getActname() {
        return Actname;
    }

    public void setActname(String actname) {
        this.Actname = actname;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    private int sno;
    private String Actname;
    private int value;
}
