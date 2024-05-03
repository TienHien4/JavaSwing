/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Data.FileData;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author tungb_000
 */
public class SanPhamQL implements Serializable{
    private FileData file;
    
    public SanPhamQL() {
        file = new FileData();
    }

    public ArrayList<Sach> getDS_Sach(){
        return file.get_Ds_Sach();
    }
    
    public ArrayList<DiaNhac> getDS_DiaNhac(){
        return file.get_Ds_DiaNhac();
    }
    
    public ArrayList<DiaPhim> getDS_DiaPhim(){
        return file.get_Ds_DiaPhim();
    }
    
    public void themSanPham(SanPham sp) {
        if (sp instanceof Sach) {
            Sach s = (Sach) sp;
            FileData.ds_Sach.add(s);
        } else if (sp instanceof DiaNhac) {
            DiaNhac dn = (DiaNhac) sp;
            FileData.ds_DiaNhac.add(dn);
        } else if (sp instanceof DiaPhim){
            DiaPhim dp = (DiaPhim) sp;
            FileData.ds_DiaPhim.add(dp);
        }
        long tongTien = sp.getGiaMua()*sp.getSoLuong();
        FileData.ds_ThuChi.add(new ThuChi(sp.getMaSanPham()+": " +sp.getTenSanPham(), tongTien, FileData.getCurrentDate(), "Nhập Kho","Nhập Kho:\n"+"Ngày: "+FileData.getCurrentDate()+"\nSản Phẩm: "+sp.getTenSanPham()+"\nSố Lượng: "+sp.getSoLuong()));
        file.writeSanPhamToFile();
        file.writeThuChiToFile();
    }

    public void suaThongTin(SanPham sp, int i) {
        if (sp instanceof Sach) {
            Sach s = (Sach) sp;
            FileData.ds_Sach.get(i).setMaSanPham(s.getMaSanPham());
            FileData.ds_Sach.get(i).setTenSanPham(s.getTenSanPham());
            FileData.ds_Sach.get(i).setTacGia(s.getTacGia());
            FileData.ds_Sach.get(i).setNhaXuatBan(s.getNhaXuatBan());
            FileData.ds_Sach.get(i).setGiaMua(s.getGiaMua());
            FileData.ds_Sach.get(i).setGiaBan(s.getGiaBan());
            FileData.ds_Sach.get(i).setSoLuong(s.getSoLuong());
            FileData.ds_Sach.get(i).setNhaCungCap(s.getNhaCungCap());
        } else if (sp instanceof DiaNhac) {
            DiaNhac dn = (DiaNhac) sp;
            FileData.ds_DiaNhac.get(i).setMaSanPham(dn.getMaSanPham());
            FileData.ds_DiaNhac.get(i).setTenSanPham(dn.getTenSanPham());
            FileData.ds_DiaNhac.get(i).setTenCaSy(dn.getTenCaSy());
            FileData.ds_DiaNhac.get(i).setTheLoai(dn.getTheLoai());
            FileData.ds_DiaNhac.get(i).setGiaMua(dn.getGiaMua());
            FileData.ds_DiaNhac.get(i).setGiaBan(dn.getGiaBan());
            FileData.ds_DiaNhac.get(i).setSoLuong(dn.getSoLuong());
            FileData.ds_DiaNhac.get(i).setNhaCungCap(dn.getNhaCungCap());
        } else {
            DiaPhim dp = (DiaPhim) sp;
            FileData.ds_DiaPhim.get(i).setMaSanPham(dp.getMaSanPham());
            FileData.ds_DiaPhim.get(i).setTenSanPham(dp.getTenSanPham());
            FileData.ds_DiaPhim.get(i).setTenDienVien(dp.getTenDienVien());
            FileData.ds_DiaPhim.get(i).setTenDaoDien(dp.getTenDaoDien());
            FileData.ds_DiaPhim.get(i).setGiaMua(dp.getGiaMua());
            FileData.ds_DiaPhim.get(i).setGiaBan(dp.getGiaBan());
            FileData.ds_DiaPhim.get(i).setSoLuong(dp.getSoLuong());
            FileData.ds_DiaPhim.get(i).setNhaCungCap(dp.getNhaCungCap());
        }
        file.writeSanPhamToFile();
    }

    public void xoaSanPham(int i) {
        int sizeSach = getDS_Sach().size();
        int sizeDiaNhac = getDS_DiaNhac().size();
        int sizeDiaPhim = getDS_DiaPhim().size();
        if (i < sizeSach) { // sach
            FileData.ds_Sach.remove(i);
        } else if (i < sizeSach + sizeDiaNhac) { // dia nhac
            FileData.ds_DiaNhac.remove(i - sizeSach);
        } else { // dia phim
            FileData.ds_DiaPhim.remove(i - sizeSach - sizeDiaNhac);
        }
        file.writeSanPhamToFile();
    }

    public void writeSanPhamToFile() {
        file.writeSanPhamToFile();
    }

    public ArrayList thongKe() {
        ArrayList ds = new ArrayList<>();
        int tongSoSP = FileData.ds_Sach.size() + FileData.ds_DiaNhac.size() + FileData.ds_DiaPhim.size();
        ds.add(tongSoSP);
        int sachSize = 0;
        long tongGiaTriSach = 0;
        for (Sach sach : FileData.ds_Sach){
            sachSize += sach.getSoLuong();
            tongGiaTriSach += sach.getGiaBan()*sach.getSoLuong();
        }
        ds.add(sachSize);
        int diaPhimSize = 0;
        long tongGiaTriDiaPhim = 0;
        for (DiaPhim dp : FileData.ds_DiaPhim){
            diaPhimSize += dp.getSoLuong();
            tongGiaTriDiaPhim+= dp.getGiaBan()*dp.getSoLuong();
        }
        ds.add(diaPhimSize);
        int diaNhacSize = 0;
        long tongGiaTriDiaNhac = 0;
        for (DiaNhac dn : FileData.ds_DiaNhac){
            diaNhacSize += dn.getSoLuong();
            tongGiaTriDiaNhac+= dn.getGiaBan()*dn.getSoLuong();
        }
        ds.add(diaNhacSize);
        long tongTien = tongGiaTriDiaNhac + tongGiaTriDiaPhim + tongGiaTriSach;
        ds.add(tongTien);
        return ds;
    }
}
