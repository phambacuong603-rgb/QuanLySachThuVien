package BTT7;

public class Test {
    public static void main(String[] args) {
        // 1. Test Yêu cầu 4: Khởi tạo bằng Constructor có đầy đủ tham số
        System.out.println("--- Test khoi tao bang Constructor ---");
        Sach sach1 = new Sach("S01", "Lap trinh Java", "Nguyen Van A", 2023, 10);
        sach1.hienThiThongTin();

        // 2. Test Yêu cầu 2: Sử dụng Setter để nhập dữ liệu HỢP LỆ
        System.out.println("\n--- Test Setter (Du lieu hop le) ---");
        Sach sach2 = new Sach(); 
        sach2.setMaSach("S02");
        sach2.setTieuDe("Cau truc du lieu");
        sach2.setTacGia("Tran Van B");
        sach2.setNamXuatBan(2020); 
        sach2.setSoLuong(5);
        sach2.hienThiThongTin();

        // 3. Test Yêu cầu 3: Kiểm tra ràng buộc dữ liệu KHÔNG HỢP LỆ 
        System.out.println("\n--- Test Setter (Du lieu KHONG hop le) ---");
        sach2.setNamXuatBan(2028); // Phải in ra thông báo lỗi năm xuất bản
        sach2.setSoLuong(-5);      // Phải in ra thông báo lỗi số lượng âm
        
        // In lại để chứng minh dữ liệu sai đã bị chặn, không làm thay đổi thông tin sách
        sach2.hienThiThongTin(); 
    }
}