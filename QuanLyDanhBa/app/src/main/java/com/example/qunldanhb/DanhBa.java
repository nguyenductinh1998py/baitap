package com.example.qunldanhb;

public class DanhBa {

    private String ten;
    private String sdt;
    private int hinh;

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }

    public DanhBa(String ten, String sdt, int hinh) {
        this.ten = ten;
        this.sdt = sdt;
        this.hinh = hinh;
    }
}
