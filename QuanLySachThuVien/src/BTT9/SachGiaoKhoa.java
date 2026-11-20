/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BTT9;
import java.util.Scanner;
/**
 *
 * @author Phạm Bá Cường
 */
public class SachGiaoKhoa extends Sach {
    private String tinhTrang; // "moi" hoặc "cu"

    public SachGiaoKhoa() {
        super();
    }
    public SachGiaoKhoa(String maSach, String ngayNhap, double donGia, int soLuong, String nhaXuatBan, String tinhTrang) {
        super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
        this.tinhTrang = tinhTrang;
    }
    @Override
    public void nhap(Scanner sc) {
        super.nhap(sc);
        System.out.print("Nhập tình trạng (moi / cu): ");
        tinhTrang = sc.nextLine();
    }
    @Override
    public double tinhThanhTien() {
        if (tinhTrang.equalsIgnoreCase("moi") || tinhTrang.equalsIgnoreCase("mới")) {
            return soLuong * donGia;
        } else {
            return soLuong * donGia * 0.5;
        }
    }
    @Override
    public void xuat() {
        super.xuat();
        System.out.printf(" | Tình trạng: %s | Thành tiền: %.2f\n", tinhTrang, tinhThanhTien());
    }      
}
