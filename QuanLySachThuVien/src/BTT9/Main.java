
package BTT9;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Sach> danhSach = new ArrayList<>();

        // 1. Nhập danh sách các loại sách
        System.out.print("Nhập số lượng Sách giáo khoa: ");
        int nSGK = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < nSGK; i++) {
            System.out.println("--- Nhập Sách giáo khoa thứ " + (i + 1) + " ---");
            SachGiaoKhoa sgk = new SachGiaoKhoa();
            sgk.nhap(sc);
            danhSach.add(sgk);
        }

        System.out.print("\nNhập số lượng Sách tham khảo: ");
        int nSTK = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < nSTK; i++) {
            System.out.println("--- Nhập Sách tham khảo thứ " + (i + 1) + " ---");
            SachThamKhao stk = new SachThamKhao();
            stk.nhap(sc);
            danhSach.add(stk);
        }

        // 2. Xuất danh sách các loại sách
        System.out.println("\n=== DANH SÁCH CÁC LOẠI SÁCH ===");
        for (Sach s : danhSach) {
            s.xuat();
        }

        // 3. Tính tổng thành tiền cho từng loại & 4. Tính TBC đơn giá sách tham khảo
        double tongTienSGK = 0;
        double tongTienSTK = 0;
        double tongDonGiaSTK = 0;
        int demSTK = 0;

        for (Sach s : danhSach) {
            if (s instanceof SachGiaoKhoa) {
                tongTienSGK += s.tinhThanhTien();
            } else if (s instanceof SachThamKhao) {
                tongTienSTK += s.tinhThanhTien();
                tongDonGiaSTK += s.getDonGia();
                demSTK++;
            }
        }

        System.out.println("\n=== THỐNG KÊ ===");
        System.out.printf("Tổng thành tiền Sách giáo khoa: %.2f\n", tongTienSGK);
        System.out.printf("Tổng thành tiền Sách tham khảo: %.2f\n", tongTienSTK);

        if (demSTK > 0) {
            System.out.printf("Trung bình cộng đơn giá Sách tham khảo: %.2f\n", (tongDonGiaSTK / demSTK));
        } else {
            System.out.println("Không có Sách tham khảo nào để tính trung bình cộng đơn giá.");
        }

        // 5. Xuất ra các sách giáo khoa của nhà xuất bản X
        System.out.print("\nNhập tên nhà xuất bản cần tìm (Sách giáo khoa): ");
        String nxbCanTim = sc.nextLine();
        boolean timThay = false;

        System.out.println("=== SÁCH GIÁO KHOA CỦA NXB \"" + nxbCanTim + "\" ===");
        for (Sach s : danhSach) {
            if (s instanceof SachGiaoKhoa && s.getNhaXuatBan().equalsIgnoreCase(nxbCanTim)) {
                s.xuat();
                timThay = true;
            }
        }

        if (!timThay) {
            System.out.println("Không tìm thấy sách giáo khoa nào của nhà xuất bản này.");
        }

        sc.close();
    }
}