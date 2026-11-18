package BTT7;

import java.util.Scanner;
import java.time.Year;

public class Sach {
    // Yêu cầu 1: Khai báo các thuộc tính với từ khóa private
    private String maSach;
    private String tieuDe;
    private String tacGia;
    private int namXuatBan;
    private int soLuong;

    // Constructor rỗng (cần thiết để bạn tạo đối tượng trước khi gọi nhapThongTin)
    public Sach() {}

    // Yêu cầu 4: Constructor có tham số đầy đủ
    public Sach(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong) {
        this.maSach = maSach;
        this.tieuDe = tieuDe;
        this.tacGia = tacGia;
        setNamXuatBan(namXuatBan); 
        setSoLuong(soLuong);
    }

    // Yêu cầu 2 & 3: Cung cấp Getter và Setter, kiểm tra điều kiện dữ liệu
    public String getMaSach() { return maSach; }
    public void setMaSach(String maSach) { this.maSach = maSach; }

    public String getTieuDe() { return tieuDe; }
    public void setTieuDe(String tieuDe) { this.tieuDe = tieuDe; }

    public String getTacGia() { return tacGia; }
    public void setTacGia(String tacGia) { this.tacGia = tacGia; }

    public int getNamXuatBan() { return namXuatBan; }
    public void setNamXuatBan(int namXuatBan) {
        int currentYear = Year.now().getValue();
        if (namXuatBan > 0 && namXuatBan <= currentYear) {
            this.namXuatBan = namXuatBan;
        } else {
            System.out.println("Lỗi: Năm xuất bản không hợp lệ (phải > 0 và <= " + currentYear + ")!");
        }
    }

    public int getSoLuong() { return soLuong; }
    public void setSoLuong(int soLuong) {
        if (soLuong >= 0) {
            this.soLuong = soLuong;
        } else {
            System.out.println("Lỗi: Số lượng không được âm!");
        }
    }

    // --- CODE TUẦN 7 CỦA BẠN (Đã sửa để dùng Setter nhằm tận dụng việc kiểm tra lỗi) ---
    public void nhapThongTin(Scanner scanner) {
        System.out.print("Nhap ma sach: ");
        setMaSach(scanner.nextLine());
        
        System.out.print("Nhap tieu de (ten sach): ");
        setTieuDe(scanner.nextLine());
        
        System.out.print("Nhap tac gia: ");
        setTacGia(scanner.nextLine());
        
        System.out.print("Nhap nam xuat ban: ");
        setNamXuatBan(Integer.parseInt(scanner.nextLine()));
        
        System.out.print("Nhap so luong: ");
        setSoLuong(Integer.parseInt(scanner.nextLine()));
    }

    public void hienThiThongTin() {
        System.out.printf("Ma sach: %s | Tieu de: %s | Tac gia: %s | Nam XB: %d | So luong: %d\n",
                maSach, tieuDe, tacGia, namXuatBan, soLuong);
    }
}