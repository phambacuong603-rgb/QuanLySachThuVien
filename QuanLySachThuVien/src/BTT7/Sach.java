package BTT7;

import java.util.Scanner;

public class Sach {
    // Yeu cau 1: Khai bao cac thuoc tinh cua lop Sach
    private String maSach;
    private String tieuDe;
    private String tacGia;
    private int namXuatBan;
    private int soLuong;

    // Phuong thuc de lay ma sach (phuc vu tim kiem, xoa)
    public String getMaSach() {
        return maSach;
    }

    // Phuong thuc nhap thong tin sach (ket hop kiem tra du lieu cua ban tu cac tuan truoc)
    public void nhapThongTin(Scanner scanner) {
        System.out.print("Nhap ma sach: ");
        maSach = scanner.nextLine();
        
        System.out.print("Nhap tieu de (ten sach): ");
        tieuDe = scanner.nextLine();
        
        System.out.print("Nhap tac gia: ");
        tacGia = scanner.nextLine();
        
        System.out.print("Nhap nam xuat ban: ");
        namXuatBan = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Nhap so luong: ");
        soLuong = Integer.parseInt(scanner.nextLine());
    }

    // Yeu cau 2: Phuong thuc hienThiThongTin() de in chi tiet ra man hinh[cite: 10]
    public void hienThiThongTin() {
        System.out.printf("Ma sach: %s | Tieu de: %s | Tac gia: %s | Nam XB: %d | So luong: %d\n",
                maSach, tieuDe, tacGia, namXuatBan, soLuong);
    }
}