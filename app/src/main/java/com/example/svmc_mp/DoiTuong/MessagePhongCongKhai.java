package com.example.svmc_mp.DoiTuong;


public class MessagePhongCongKhai {
    private String idPhong;
    private String username;
    private String noiDungTinNhan;
    private String tenNguoiGui;

    public MessagePhongCongKhai() {
    }

    public MessagePhongCongKhai(String idPhong, String username, String tenNguoiGui, String noiDungTinNhan) {
        this.idPhong = idPhong;
        this.username = username;
        this.noiDungTinNhan = noiDungTinNhan;
        this.tenNguoiGui = tenNguoiGui;
    }

    public String getIdPhong() {
        return idPhong;
    }

    public void setIdPhong(String idPhong) {
        this.idPhong = idPhong;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNoiDungTinNhan() {
        return noiDungTinNhan;
    }

    public void setNoiDungTinNhan(String noiDungTinNhan) {
        this.noiDungTinNhan = noiDungTinNhan;
    }


    public String getTenNguoiGui() {
        return tenNguoiGui;
    }

    public void setTenNguoiGui(String tenNguoiGui) {
        this.tenNguoiGui = tenNguoiGui;
    }


}
