package com.example.svmc_mp.DoiTuong;

public class PhongCongKhai {
    private int resourceID;
    private String namePhong;
    private String idPhong;

    public PhongCongKhai(String idPhong, int resourceID, String namePhong) {
        this.resourceID = resourceID;
        this.namePhong = namePhong;
        this.idPhong = idPhong;
    }

    public int getResourceID() {
        return resourceID;
    }

    public void setResourceID(int resourceID) {
        this.resourceID = resourceID;
    }

    public String getNamePhong() {
        return namePhong;
    }

    public void setNamePhong(String namePhong) {
        this.namePhong = namePhong;
    }

    public String getIdPhong() {
        return idPhong;
    }

    public void setIdPhong(String idPhong) {
        this.idPhong = idPhong;
    }
}