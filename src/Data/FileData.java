package Data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DiaNhac;
import model.DiaPhim;
import model.HoaDon;
import model.NhanVien;
import model.Sach;
import model.SanPham;
import model.ThuChi;

/**
 *
 * @author tungb_000
 */
public class FileData {

    //public static ArrayList<SanPham> ds_SanPham = new ArrayList<SanPham>();
    public static ArrayList<NhanVien> ds_NhanVien = new ArrayList<>(); //type = 0
    public static ArrayList<DiaNhac> ds_DiaNhac = new ArrayList<>(); //type = 1
    public static ArrayList<DiaPhim> ds_DiaPhim = new ArrayList<>(); // type = 2
    public static ArrayList<Sach> ds_Sach = new ArrayList<>(); // type = 3
    public static ArrayList<HoaDon> ds_HoaDon = new ArrayList<>();
    public static ArrayList<ThuChi> ds_ThuChi = new ArrayList<>();
    File file, file1, file2, file3;

    public FileData() {
        try {
            file = new File("C:\\Users\\GiGa\\eclipse-workspace\\JavaSwing\\src\\DanhSachSanPham.txt");
            FileInputStream fos = new FileInputStream(file);
            ObjectInputStream oos = new ObjectInputStream(fos);
            getDanhSachSanPham();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            file1 = new File("C:\\Users\\GiGa\\eclipse-workspace\\JavaSwing\\src\\DanhSachNhanVien.txt");
            FileInputStream fos = new FileInputStream(file1);
            ObjectInputStream oos = new ObjectInputStream(fos);
            getDanhSachNhanVien();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            file2 = new File("C:\\Users\\GiGa\\eclipse-workspace\\JavaSwing\\src\\DanhSachThuChi.txt");
            FileInputStream fos = new FileInputStream(file2);
            ObjectInputStream oos = new ObjectInputStream(fos);
            getDanhSachThuChi();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            file3 = new File("C:\\Users\\GiGa\\eclipse-workspace\\JavaSwing\\src\\DanhSachHoaDon.txt");
            FileInputStream fos = new FileInputStream(file3);
            ObjectInputStream oos = new ObjectInputStream(fos);
            getDanhSachHoaDon();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeSanPhamToFile() {
        try {
            file = new File("C:\\Users\\GiGa\\eclipse-workspace\\JavaSwing\\src\\DanhSachSanPham.txt");
            if (file.exists()) {
                file.delete();
            }
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(ds_Sach);
            oos.close();
            fos.close();
        } catch (Exception ex) {
            Logger.getLogger(FileData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getDanhSachSanPham() {
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            ds_Sach = (ArrayList<Sach>) ois.readObject();
            ois.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeNhanVienToFile() {
        try {
            file1 = new File("C:\\Users\\GiGa\\eclipse-workspace\\JavaSwing\\src\\DanhSachNhanVien.txt");
            if (file1.exists()) {
                file1.delete();
            }
            FileOutputStream fos = new FileOutputStream(file1);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(ds_NhanVien);
            oos.close();
            fos.close();
        } catch (Exception ex) {
            Logger.getLogger(FileData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getDanhSachNhanVien() {
        try {
            FileInputStream fis = new FileInputStream(file1);
            ObjectInputStream ois = new ObjectInputStream(fis);
            ds_NhanVien = (ArrayList<NhanVien>) ois.readObject();
            ois.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeThuChiToFile() {
        try {
            file2 = new File("C:\\Users\\GiGa\\eclipse-workspace\\JavaSwing\\src\\DanhSachThuChi.txt");
            if (file2.exists()) {
                file2.delete();
            }
            FileOutputStream fos = new FileOutputStream(file2);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(ds_ThuChi);
            oos.close();
            fos.close();
        } catch (Exception ex) {
            Logger.getLogger(FileData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getDanhSachThuChi() {
        try {
            FileInputStream fis = new FileInputStream(file2);
            ObjectInputStream ois = new ObjectInputStream(fis);
            ds_ThuChi = (ArrayList  <ThuChi>) ois.readObject();
            ois.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeHoaDonToFile() {
        try {
            file3 = new File("C:\\Users\\GiGa\\eclipse-workspace\\JavaSwing\\src\\DanhSachHoaDon.txt");
            if (file3.exists()) {
                file3.delete();
            }
            FileOutputStream fos = new FileOutputStream(file3);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(ds_HoaDon);
            oos.close();
            fos.close();
        } catch (Exception ex) {
            Logger.getLogger(FileData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getDanhSachHoaDon() {
        try {
            FileInputStream fis = new FileInputStream(file3);
            ObjectInputStream ois = new ObjectInputStream(fis);
            ds_HoaDon = (ArrayList<HoaDon>) ois.readObject();
            ois.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void updatedanhSachHoaDon() throws IOException {
        file3.delete();
        BufferedWriter bw = new BufferedWriter(new FileWriter(file3));
        for (int i = 0; i < ds_HoaDon.size(); i++) {
            HoaDon hd = ds_HoaDon.get(i);
            bw.write(hd.getMaHoaDon() + "," + hd.getNgay() + "," + hd.getTongTien() + "," + hd.getDs_SanPham().size() + ",");
            for (int k = 0; k < hd.getDs_SanPham().size(); k++) {
                SanPham sp = hd.getDs_SanPham().get(k);
                bw.write(sp.getMaSanPham() + "," + sp.getTenSanPham() + "," + sp.getGiaBan() + "," + sp.getSoLuong() + ",");
            }
            bw.newLine();
        }
        bw.close();
    }

    public ArrayList<HoaDon> get_Ds_Hoa_Don() {
        return ds_HoaDon;
    }

    public ArrayList<ThuChi> get_Ds_ThuChi() {
        return ds_ThuChi;
    }

    public ArrayList<NhanVien> get_Ds_NhanVien() {
        return ds_NhanVien;
    }

    public ArrayList<Sach> get_Ds_Sach() {
        return ds_Sach;
    }

    public ArrayList<DiaNhac> get_Ds_DiaNhac() {
        return ds_DiaNhac;
    }

    public ArrayList<DiaPhim> get_Ds_DiaPhim() {
        return ds_DiaPhim;
    }

   

    public static String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date dates = new Date();
        return dateFormat.format(dates);
    }

}
