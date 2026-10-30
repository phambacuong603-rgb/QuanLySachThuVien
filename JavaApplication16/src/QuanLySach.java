/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.util.Scanner;
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

        // Bài 1: Nhập dữ liệu từ bàn phím
        System.out.println("--- NHẬP THÔNG TIN SÁCH ---");
        
        System.out.print("Nhập mã sách: ");
        String maSach = scanner.nextLine();

        System.out.print("Nhập tên sách: ");
        String tenSach = scanner.nextLine();

        System.out.print("Nhập tác giả: ");
        String tacGia = scanner.nextLine();

        System.out.print("Nhập năm xuất bản: ");
        int namXuatBan = scanner.nextInt();

        System.out.print("Nhập đơn giá: ");
        double donGia = scanner.nextDouble();

        System.out.print("Nhập số lượng: ");
        int soLuong = scanner.nextInt();

        // Bài 2: Tính thành tiền = đơn giá x số lượng
        double thanhTien = donGia * soLuong;

        // Bài 3: Phí vận chuyển = 5% giá trị sách (dựa trên thành tiền)
        double phiVanChuyen = thanhTien * 0.05; 

        // Bài 4: Tổng tiền nhập = Thành tiền + Phí vận chuyển
        double tongTienNhap = thanhTien + phiVanChuyen;

        // Hiển thị lại toàn bộ thông tin
        System.out.println("\n--- KẾT QUẢ NHẬP KHO ---");
        System.out.println("Mã sách: " + maSach);
        System.out.println("Tên sách: " + tenSach);
        System.out.println("Tác giả: " + tacGia);
        System.out.println("Năm xuất bản: " + namXuatBan);
        System.out.println("Đơn giá: " + donGia);
        System.out.println("Số lượng: " + soLuong);
        System.out.println("Thành tiền: " + thanhTien);
        System.out.println("Phí vận chuyển: " + phiVanChuyen);
        System.out.println("Tổng tiền nhập: " + tongTienNhap);

        scanner.close();
    }   
}
