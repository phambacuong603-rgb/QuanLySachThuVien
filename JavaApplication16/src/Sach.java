
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Phạm Bá Cường
 */
public class Sach {
    String maSach, tenSach, tacGia, tenLoaiSach, phanLoaiGia, tinhTrangKho;
    int namXuatBan, soLuong;
    double donGia, thanhTien, phiVanChuyen, tongTienNhap;

    // Đưa đoạn code nhập và tính toán của bạn vào hàm này
    public void nhapVaTinhToan(Scanner scanner, int namHienTai) {
        boolean duLieuHopLe;
        do {
            duLieuHopLe = true;
            System.out.print("Nhap ma sach: ");
            maSach = scanner.nextLine();
            System.out.print("Nhap ten sach: ");
            tenSach = scanner.nextLine();
            System.out.print("Nhap tac gia: ");
            tacGia = scanner.nextLine();
            System.out.print("Nhap nam xuat ban: ");
            namXuatBan = Integer.parseInt(scanner.nextLine());
            System.out.print("Nhap don gia: ");
            donGia = Double.parseDouble(scanner.nextLine());
            System.out.print("Nhap so luong: ");
            soLuong = Integer.parseInt(scanner.nextLine());

            // Kiểm tra tính hợp lệ (Code Tuần 4 của bạn)
            if (donGia <= 0) {
                System.out.println("Loi: Gia sach phai > 0.");
                duLieuHopLe = false;
            } else if (soLuong < 0) {
                System.out.println("Loi: So luong khong duoc am (phai >= 0).");
                duLieuHopLe = false;
            } else if (namXuatBan <= 0 || namXuatBan > namHienTai) {
                System.out.println("Loi: Nam xuat ban khong hop le.");
                duLieuHopLe = false;
            }

            if (!duLieuHopLe) {
                System.out.println("--> Vui long nhap lai thong tin cho cuon sach nay!\n");
            }
        } while (!duLieuHopLe); // Lặp lại việc nhập cuốn sách này nếu dữ liệu sai

        // Chọn loại sách (Code Tuần 4)
        System.out.println("1. Sach giao khoa | 2. Sach tham khao | 3. Sach chuyen nganh | 4. Sach khac");
        System.out.print("Vui long chon loai sach (1-4): ");
        int loaiSachCode = Integer.parseInt(scanner.nextLine());
        switch (loaiSachCode) {
            case 1: tenLoaiSach = "Sach giao khoa"; break;
            case 2: tenLoaiSach = "Sach tham khao"; break;
            case 3: tenLoaiSach = "Sach chuyen nganh"; break;
            case 4: tenLoaiSach = "Sach khac"; break;
            default: tenLoaiSach = "Khong xac dinh"; break;
        }

        // Tính toán và phân loại (Code Tuần 4)
        thanhTien = donGia * soLuong;
        phiVanChuyen = thanhTien * 0.05; 
        tongTienNhap = thanhTien + phiVanChuyen;

        if (donGia < 50000) phanLoaiGia = "Sach gia thap";
        else if (donGia <= 100000) phanLoaiGia = "Sach gia trung binh";
        else if (donGia <= 200000) phanLoaiGia = "Sach gia cao";
        else phanLoaiGia = "Sach gia dac biet";

        if (soLuong == 0) tinhTrangKho = "Het sach";
        else if (soLuong <= 5) tinhTrangKho = "Sap het";
        else if (soLuong <= 20) tinhTrangKho = "Con it";
        else tinhTrangKho = "Con nhieu";
    }

    // Hàm in thông tin
    public void xuatThongTin() {
        System.out.println("Ma: " + maSach + " | Ten: " + tenSach + " | Phan loai: " + tenLoaiSach + 
                           " | Gia: " + (long)donGia + " (" + phanLoaiGia + ") | SL: " + soLuong + 
                           " (" + tinhTrangKho + ") | Tong nhap: " + (long)tongTienNhap);
    }
}

