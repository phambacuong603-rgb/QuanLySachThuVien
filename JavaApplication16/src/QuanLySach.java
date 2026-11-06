/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.util.Scanner;
import java.time.Year;

// Tạo một lớp Sách để lưu trữ thông tin của từng cuốn sách
class Sach {
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

public class QuanLySach {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int namHienTai = Year.now().getValue();
        Sach[] danhSach = null;
        int n = 0;
        int luaChon = 0;

        // BÀI 3: MENU LẶP BẰNG DO-WHILE
        do {
            System.out.println("\n===== MENU TUẦN 5 =====");
            System.out.println("1. Nhap n sach (Bai 1)");
            System.out.println("2. Tinh tong so luong va tong gia tri (Bai 2)");
            System.out.println("3. Tim sach theo ma (Bai 4)");
            System.out.println("0. Thoat");
            System.out.print("Chon chuc nang: ");
            luaChon = Integer.parseInt(scanner.nextLine());

            switch (luaChon) {
                case 1: // BÀI 1: NHẬP N SÁCH BẰNG VÒNG LẶP FOR
                    System.out.print("Nhap so luong sach can them (n): ");
                    n = Integer.parseInt(scanner.nextLine());
                    danhSach = new Sach[n];
                    for (int i = 0; i < n; i++) {
                        System.out.println("\n--- Nhap sach thu " + (i + 1) + " ---");
                        danhSach[i] = new Sach();
                        danhSach[i].nhapVaTinhToan(scanner, namHienTai);
                    }
                    System.out.println("=> Da nhap xong!");
                    break;

                case 2: // BÀI 2: TÍNH TỔNG BẰNG VÒNG LẶP FOR
                    if (danhSach != null && n > 0) {
                        int tongSL = 0;
                        double tongGiaTri = 0;
                        for (int i = 0; i < n; i++) {
                            tongSL += danhSach[i].soLuong;
                            tongGiaTri += danhSach[i].tongTienNhap;
                        }
                        System.out.println("Tong so luong sach: " + tongSL);
                        System.out.println("Tong gia tri nhap (bao gom phi VC): " + (long)tongGiaTri + " VND");
                    } else {
                        System.out.println("Danh sach trong!");
                    }
                    break;

                case 3: // BÀI 4: TÌM KIẾM BẰNG VÒNG LẶP FOR
                    if (danhSach != null && n > 0) {
                        System.out.print("Nhap ma sach can tim: ");
                        String maTim = scanner.nextLine();
                        boolean thay = false;
                        for (int i = 0; i < n; i++) {
                            if (danhSach[i].maSach.equalsIgnoreCase(maTim)) {
                                danhSach[i].xuatThongTin();
                                thay = true;
                                break;
                            }
                        }
                        if (!thay) System.out.println("Khong tim thay!");
                    } else {
                        System.out.println("Danh sach trong!");
                    }
                    break;

                case 0:
                    System.out.println("Tam biet!");
                    break;
                default:
                    System.out.println("Chon sai, vui long chon lai!");
            }
        } while (luaChon != 0);

        scanner.close();
    }
}