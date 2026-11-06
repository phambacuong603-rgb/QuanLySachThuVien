/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.time.Year;

public class QuanLySach {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int namHienTai = Year.now().getValue();
        
        // BÀI 3: Khởi tạo danh sách bằng ArrayList thay vì Mảng tĩnh (Array)
        ArrayList<Sach> danhSach = new ArrayList<>();
        int luaChon = 0;

        // BÀI 4: Xây dựng menu hoàn chỉnh 8 chức năng
        do {
            System.out.println("\n===== MENU TUẦN 6 (ARRAYLIST) =====");
            System.out.println("1. Thêm sách");
            System.out.println("2. Hiển thị sách");
            System.out.println("3. Tìm sách");
            System.out.println("4. Xóa sách");
            System.out.println("5. Sửa sách");
            System.out.println("6. Tính tổng số lượng");
            System.out.println("7. Tính tổng giá trị");
            System.out.println("8. Thoát");
            System.out.print("Chọn chức năng (1-8): ");
            
            try {
                luaChon = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
                continue;
            }

            switch (luaChon) {
                case 1: // 1. Thêm sách (Dùng add)
                    Sach sachMoi = new Sach();
                    System.out.println("\n--- Nhập thông tin sách mới ---");
                    sachMoi.nhapVaTinhToan(scanner, namHienTai);
                    danhSach.add(sachMoi);
                    System.out.println("=> Đã thêm sách thành công!");
                    break;

                case 2: // 2. Hiển thị sách (Dùng vòng lặp và size())
                    if (danhSach.isEmpty()) {
                        System.out.println("Danh sách hiện đang trống!");
                    } else {
                        System.out.println("\n--- DANH SÁCH CÁC CUỐN SÁCH ---");
                        for (int i = 0; i < danhSach.size(); i++) {
                            System.out.print("Sách " + (i + 1) + ": ");
                            danhSach.get(i).xuatThongTin();
                        }
                    }
                    break;

                case 3: // 3. Tìm sách
                    if (danhSach.isEmpty()) {
                        System.out.println("Danh sách trống, không có dữ liệu để tìm!");
                        break;
                    }
                    System.out.print("Nhập mã sách cần tìm: ");
                    String maTim = scanner.nextLine();
                    boolean timThay = false;
                    for (Sach s : danhSach) {
                        if (s.maSach.equalsIgnoreCase(maTim)) {
                            System.out.println("=> Đã tìm thấy:");
                            s.xuatThongTin();
                            timThay = true;
                            break;
                        }
                    }
                    if (!timThay) System.out.println("Không tìm thấy sách có mã: " + maTim);
                    break;

                case 4: // 4. Xóa sách (Dùng remove)
                    if (danhSach.isEmpty()) {
                        System.out.println("Danh sách trống!");
                        break;
                    }
                    System.out.print("Nhập mã sách cần xóa: ");
                    String maXoa = scanner.nextLine();
                    boolean daXoa = false;
                    for (int i = 0; i < danhSach.size(); i++) {
                        if (danhSach.get(i).maSach.equalsIgnoreCase(maXoa)) {
                            danhSach.remove(i);
                            System.out.println("=> Đã xóa sách thành công!");
                            daXoa = true;
                            break;
                        }
                    }
                    if (!daXoa) System.out.println("Không tìm thấy sách có mã " + maXoa + " để xóa.");
                    break;

                case 5: // 5. Sửa sách (Dùng set)
                    if (danhSach.isEmpty()) {
                        System.out.println("Danh sách trống!");
                        break;
                    }
                    System.out.print("Nhập mã sách cần sửa: ");
                    String maSua = scanner.nextLine();
                    boolean daSua = false;
                    for (int i = 0; i < danhSach.size(); i++) {
                        if (danhSach.get(i).maSach.equalsIgnoreCase(maSua)) {
                            System.out.println("=> Tìm thấy sách. Vui lòng nhập thông tin cập nhật:");
                            Sach sachSua = new Sach();
                            sachSua.nhapVaTinhToan(scanner, namHienTai);
                            
                            // Sử dụng phương thức set() của ArrayList để ghi đè phần tử
                            danhSach.set(i, sachSua); 
                            System.out.println("=> Đã cập nhật thông tin sách thành công!");
                            daSua = true;
                            break;
                        }
                    }
                    if (!daSua) System.out.println("Không tìm thấy sách có mã " + maSua + " để sửa.");
                    break;

                case 6: // 6. Tính tổng số lượng
                    int tongSL = 0;
                    for (Sach s : danhSach) {
                        tongSL += s.soLuong;
                    }
                    System.out.println("=> Tổng số lượng sách hiện có trong thư viện: " + tongSL);
                    break;

                case 7: // 7. Tính tổng giá trị
                    double tongGiaTri = 0;
                    for (Sach s : danhSach) {
                        tongGiaTri += s.tongTienNhap;
                    }
                    System.out.println("=> Tổng giá trị tất cả sách: " + (long)tongGiaTri + " VND");
                    break;

                case 8: // 8. Thoát
                    System.out.println("Đã thoát chương trình quản lý thư viện!");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn từ 1 đến 8!");
            }
        } while (luaChon != 8);

        scanner.close();
    }
}