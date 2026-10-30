/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.util.Scanner;
import java.time.Year;
/**
 *
 * @author Phạm Bá Cường
 */
public class QuanLySach {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int namHienTai = Year.now().getValue();

        // --- NHẬP THÔNG TIN SÁCH (Tuần 3) ---
        System.out.println("--- NHAP THONG TIN SACH ---");
        System.out.print("Nhap ma sach: ");
        String maSach = scanner.nextLine();
        
        System.out.print("Nhap ten sach: ");
        String tenSach = scanner.nextLine();
        
        System.out.print("Nhap tac gia: ");
        String tacGia = scanner.nextLine();
        
        System.out.print("Nhap nam xuat ban: ");
        int namXuatBan = scanner.nextInt();
        
        System.out.print("Nhap don gia: ");
        double donGia = scanner.nextDouble();
        
        System.out.print("Nhap so luong: ");
        int soLuong = scanner.nextInt();

        // --- BAI 1: KIEM TRA TINH HOP LE (Tuan 4) ---
        boolean duLieuHopLe = true;
        
        // Kiem tra phan cap cho du lieu
        if (donGia <= 0) {
            System.out.println("Loi: Gia sach phai > 0.");
            duLieuHopLe = false;
        } else {
            if (soLuong < 0) {
                System.out.println("Loi: So luong khong duoc am (phai >= 0).");
                duLieuHopLe = false;
            } else {
                if (namXuatBan <= 0 || namXuatBan > namHienTai) {
                    System.out.println("Loi: Nam xuat ban khong hop le.");
                    duLieuHopLe = false;
                }
            }
        }

        // Neu du lieu khong hop le, dung chuong trinh
        if (!duLieuHopLe) {
            System.out.println("Vui long chay lai chuong trinh va nhap du lieu dung.");
            return; 
        }

        // --- BAI 4: CHON LOAI SACH (Tuan 4) ---
        System.out.println("\n--- CHON LOAI SACH ---");
        System.out.println("1. Sach giao khoa");
        System.out.println("2. Sach tham khao");
        System.out.println("3. Sach chuyen nganh");
        System.out.println("4. Sach khac");
        System.out.print("Vui long chon loai sach (1-4): ");
        int loaiSachCode = scanner.nextInt();
        String tenLoaiSach = "";
        
        switch (loaiSachCode) {
            case 1: tenLoaiSach = "Sach giao khoa"; break;
            case 2: tenLoaiSach = "Sach tham khao"; break;
            case 3: tenLoaiSach = "Sach chuyen nganh"; break;
            case 4: tenLoaiSach = "Sach khac"; break;
            default: tenLoaiSach = "Khong xac dinh"; break;
        }

        // --- BAI 2 & BAI 3 & TINH TOAN (Ket hop Tuan 3 & 4) ---
        // Tinh toan
        double thanhTien = donGia * soLuong;
        double phiVanChuyen = thanhTien * 0.05; 
        double tongTienNhap = thanhTien + phiVanChuyen;

       // Phan loai gia 
        String phanLoaiGia = "";
        if (donGia < 50000) {
            phanLoaiGia = "Sach gia thap";
        } else {
            if (donGia <= 100000) {
                phanLoaiGia = "Sach gia trung binh";
            } else {
                if (donGia <= 200000) {
                    phanLoaiGia = "Sach gia cao";
                } else {
                    phanLoaiGia = "Sach gia dac biet";
                }
            }
        }

       // Phan loai ton kho 
        String tinhTrangKho = "";
        if (soLuong == 0) {
            tinhTrangKho = "Het sach";
        } else {
            if (soLuong <= 5) {
                tinhTrangKho = "Sap het";
            } else {
                if (soLuong <= 20) {
                    tinhTrangKho = "Con it";
                } else {
                    tinhTrangKho = "Con nhieu";
                }
            }
        }

        // --- IN KET QUA TONG HOP ---
        System.out.println("\n--- THONG TIN CHI TIET SACH DA NHAP ---");
        System.out.println("Ma sach: " + maSach);
        System.out.println("Ten sach: " + tenSach);
        System.out.println("Tac gia: " + tacGia);
        System.out.println("Phan loai: " + tenLoaiSach);
        System.out.println("Nam xuat ban: " + namXuatBan);
        System.out.println("Don gia: " + (long)donGia + " VND (" + phanLoaiGia + ")");
        System.out.println("So luong: " + soLuong + " (" + tinhTrangKho + ")");
        System.out.println("Thanh tien: " + (long)thanhTien + " VND");
        System.out.println("Phi van chuyen: " + (long)phiVanChuyen + " VND");
        System.out.println("Tong tien nhap: " + (long)tongTienNhap + " VND");

        scanner.close();
    }   
}
