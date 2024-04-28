/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Data.FileData;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author tungb_000
 */
public class HoaDonQL {
    
    FileData file;
    
    public HoaDonQL(){
        file = new FileData();
    }
    
    public ArrayList<HoaDon> get_Ds_HoaDon(){
        return FileData.ds_HoaDon;
    }
    
    public void xoaHoaDon(int index) throws IOException{
        FileData.ds_HoaDon.remove(index);
        file.updatedanhSachHoaDon();
    }

    public void themHoaDon(HoaDon hd) throws IOException {
        FileData.ds_HoaDon.add(hd);
        String noiDung = "";
        for (int i= 0;i<hd.getDs_SanPham().size();i++){
            SanPham sp = hd.getDs_SanPham().get(i);
            noiDung+= "Sản Phẩm: "+sp.getTenSanPham() + "\nSố Lượng: " +sp.getSoLuong()+"\n";
        }
        FileData.ds_ThuChi.add(new ThuChi(hd.getMaHoaDon(), hd.getTongTien(), FileData.getCurrentDate(), "Hóa Đơn", noiDung));
        file.writeHoaDonToFile();
        file.writeThuChiToFile();
    }
    
//    public void writeHoaDonToFile() {
//        file.writeHoaDonToFile();
//    }
}
