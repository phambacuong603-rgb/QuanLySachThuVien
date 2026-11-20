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
public class Sach {
    protected String maSach;
    protected String ngayNhap; // Định dạng dd/mm/yyyy
    protected double donGia;
    protected int soLuong;
    protected String nhaXuatBan;
    public Sach() {
    }
    public Sach(String maSach, String ngayNhap, double donGia, int soLuong, String nhaXuatBan) {
        this.maSach = maSach;
        this.ngayNhap = ngayNhap;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.nhaXuatBan = nhaXuatBan;
    }
    public double getDonGia() {
        return donGia;
    }
    public String getNhaXuatBan() {
        return nhaXuatBan;
    }
    public void nhap(Scanner sc) {
        System.out.print("Nhập mã sách: ");
        maSach = sc.nextLine();
        System.out.print("Nhập ngày nhập (dd/mm/yyyy): ");
        ngayNhap = sc.nextLine();
        System.out.print("Nhập đơn giá: ");
        donGia = Double.parseDouble(sc.nextLine());
        System.out.print("Nhập số lượng: ");
        soLuong = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập nhà xuất bản: ");
        nhaXuatBan = sc.nextLine();
    }
    public double tinhThanhTien() {
        return 0;
    }
    public void xuat() {
        System.out.printf("Mã: %s | Ngày nhập: %s | Đơn giá: %.2f | SL: %d | NXB: %s",
                maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
    }
}
 