package BTT7;

import java.util.ArrayList;
import java.util.Scanner;

// Yeu cau 3: Xay dung lop Test[cite: 10]
public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Yeu cau 4: Tao va quan ly danh sach Sach bang ArrayList[cite: 10]
        ArrayList<Sach> danhSachSach = new ArrayList<>();
        int luaChon = 0;

        do {
            System.out.println("\n===== CHUONG TRINH QUAN LY SACH =====");
            System.out.println("1. Them sach moi");
            System.out.println("2. Hien thi danh sach sach");
            System.out.println("3. Tim kiem sach theo ma");
            System.out.println("4. Xoa sach theo ma");
            System.out.println("0. Thoat");
            System.out.print("Moi ban chon chuc nang (0-4): ");
            
            try {
                luaChon = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Vui long nhap so!");
                continue;
            }

            switch (luaChon) {
                case 1:
                    System.out.println("\n--- Nhap thong tin sach ---");
                    Sach sachMoi = new Sach(); // Tao doi tuong tu lop Sach[cite: 10]
                    sachMoi.nhapThongTin(scanner);
                    danhSachSach.add(sachMoi);
                    System.out.println("=> Them sach thanh cong!");
                    break;
                    
                case 2:
                    if (danhSachSach.isEmpty()) {
                        System.out.println("Danh sach trong!");
                    } else {
                        System.out.println("\n--- DANH SACH THU VIEN ---");
                        for (Sach s : danhSachSach) {
                            s.hienThiThongTin(); // Goi phuong thuc hienThiThongTin()[cite: 10]
                        }
                    }
                    break;
                    
                case 3:
                    System.out.print("Nhap ma sach can tim: ");
                    String maTim = scanner.nextLine();
                    boolean timThay = false;
                    for (Sach s : danhSachSach) {
                        if (s.getMaSach().equalsIgnoreCase(maTim)) {
                            s.hienThiThongTin();
                            timThay = true;
                            break;
                        }
                    }
                    if (!timThay) System.out.println("Khong tim thay!");
                    break;
                    
                case 4:
                    System.out.print("Nhap ma sach can xoa: ");
                    String maXoa = scanner.nextLine();
                    boolean daXoa = false;
                    for (int i = 0; i < danhSachSach.size(); i++) {
                        if (danhSachSach.get(i).getMaSach().equalsIgnoreCase(maXoa)) {
                            danhSachSach.remove(i);
                            System.out.println("=> Da xoa thanh cong!");
                            daXoa = true;
                            break;
                        }
                    }
                    if (!daXoa) System.out.println("Khong tim thay sach de xoa!");
                    break;
                    
                case 0:
                    System.out.println("Chuong trinh ket thuc!");
                    break;
                    
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (luaChon != 0);
        
        scanner.close();
    }
}