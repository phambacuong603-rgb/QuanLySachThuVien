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
public class SachThamKhao extends Sach{
    private double thue;
    public SachThamKhao() {
        super();
    }
    public SachThamKhao(String maSach, String ngayNhap, double donGia, int soLuong, String nhaXuatBan, double thue) {
        super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
        this.thue = thue;
    }
    @Override
    public void nhap(Scanner sc) {
        super.nhap(sc);
        System.out.print("Nhập thuế: ");
        thue = Double.parseDouble(sc.nextLine());
    }
    @Override
    public double tinhThanhTien() {
        return soLuong * donGia + thue;
    }
    @Override
    public void xuat() {
        super.xuat();
        System.out.printf(" | Thuế: %.2f | Thành tiền: %.2f\n", thue, tinhThanhTien());
    }  
}
