/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Data.FileData;
import java.util.ArrayList;

/**
 *
 * @author tungb_000
 */
public class NhanVienQL {
    private FileData file;

    public NhanVienQL() {
        file = new FileData();
    }

    public ArrayList<NhanVien> getDS_NhanVien() {
        return file.get_Ds_NhanVien();
    }

    public void themNhanVien(NhanVien nv) {
        FileData.ds_NhanVien.add(nv);
        file.writeNhanVienToFile();
    }

    public void suaThongTin(NhanVien nv, int i) {
        FileData.ds_NhanVien.get(i).setMaNhanVien(nv.getMaNhanVien());
        FileData.ds_NhanVien.get(i).setTenNhanVien(nv.getTenNhanVien());
        FileData.ds_NhanVien.get(i).setNgaySinh(nv.getNgaySinh());
        FileData.ds_NhanVien.get(i).setGioiTinh(nv.getGioiTinh());
        FileData.ds_NhanVien.get(i).setEmail(nv.getEmail());
        FileData.ds_NhanVien.get(i).setSoDienThoai(nv.getSoDienThoai());
        FileData.ds_NhanVien.get(i).setTenDangNhap(nv.getTenDangNhap());
        FileData.ds_NhanVien.get(i).setMatKhau(nv.getMatKhau());
        FileData.ds_NhanVien.get(i).setChucVu(nv.getChucVu());
        FileData.ds_NhanVien.get(i).setDiaChi(nv.getDiaChi());
        FileData.ds_NhanVien.get(i).setLuongTheoThang(nv.getLuongTheoThang());
        file.writeNhanVienToFile();
    }

    public void xoaNhanVien(int i) {
        FileData.ds_NhanVien.remove(i);
        file.writeNhanVienToFile();
    }

    public void writeNhanVienToFile() {
        file.writeNhanVienToFile();
    }
    
    public void traLuong(){
        
    }

    public ArrayList thongKe() {
        ArrayList ds = new ArrayList();
        int tongSoNV = FileData.ds_NhanVien.size();
        long tongLuong = 0;
        int soBaoVe = 0;
        int soBanHang = 0;
        for (NhanVien nv : FileData.ds_NhanVien){
            tongLuong += nv.getLuongTheoThang();
            if (nv.getChucVu().equalsIgnoreCase("Bảo Vệ")) {
                soBaoVe++;
            } else if (nv.getChucVu().equalsIgnoreCase("Bán Hàng")) {
                soBanHang++;
            } 
        }
        ds.add(tongSoNV);
        ds.add(tongLuong);
        ds.add(soBaoVe);
        ds.add(soBanHang);
        return ds;
    }
}
