package main;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.List;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException, ParseException, FileNotFoundException {
        int choice;
        NguoiDung me = new NguoiDung();

        while (true) {
            clearScreen();
            System.out.println("CHÀO MỪNG ĐẾN VỚI HỆ THỐNG LUYỆN TẬP TRẮC NGHIỆM TIẾNG ANH");
            if (!Config.dangNhap) {
                System.out.println("=================================================================");
                System.out.println("\t\t\t1.ĐĂNG NHẬP");
                System.out.println("\t\t\t2.ĐĂNG KÍ");
                System.out.println("\t\t\t3.THOÁT");
                choice = nhapLuaChon(3);
                switch (choice) {
                    case 1:
                        System.out.println("DANG NHAP");
                        me = QuanLyNguoiDung.dangNhap();
                        break;
                    case 2:
                        System.out.println("DANG KI");
                        me = QuanLyNguoiDung.dangKi();
                        break;
                    case 3:
                        System.out.println("HEN GAP LAI!!");
                        break;
                }
                if (choice == 3) break;
            } else {
                System.out.println("*=====*=====*=====*=====*=====*=====*=====*=====*=====*=====*");
                System.out.printf("Xin chào, %s\nChức danh: %s\n", me.getUsername(), me.isAdmin() ? "ADMIN" : "HOC VIEN");
                menu();
                choice = nhapLuaChon(5);
                int c;
                switch (choice) {
                    case 1:
                        if (me.isAdmin())
                            do {
                                clearScreen();
                                qlNguoiDung();
                                c = nhapLuaChon(9);
                                switch(c) {
                                    case 1:
                                        System.out.println("DANH SÁCH NGƯỜI DÙNG:");
                                        QuanLyNguoiDung.hienThi();
                                        break;
                                    case 2:
                                        System.out.println("TIM KIEM THEO TEN:");
                                        XuatDSND(QuanLyNguoiDung.traCuu(Config.sc.nextLine()));
                                        break;
                                    case 3:
                                        System.out.println("TIM KIEM THEO QUE QUAN:");
                                        XuatDSND(QuanLyNguoiDung.traCuuTheoQueQuan(Config.sc.nextLine()));
                                        break;
                                    case 4:
                                        System.out.println("TIM KIEM THEO GIOI TINH:");
                                        XuatDSND(QuanLyNguoiDung.traCuu(Config.sc.nextLine().toUpperCase().equals("NAM")));
                                        break;
                                    case 5:
                                        System.out.println("TIM KIEM THEO NGAY SINH:");
                                        XuatDSND(QuanLyNguoiDung.traCuu(Config.toCalendar(Config.sc.nextLine())));
                                        break;
                                    case 6:
                                        System.out.println("THEM HOC VIEN");
                                        QuanLyNguoiDung.them();
                                        break;
                                    case 7:
                                        System.out.println("XOA HOC VIEN");
                                        System.out.print("Nhập mã người dùng: ");
                                        QuanLyNguoiDung.xoa(Integer.parseInt(Config.sc.nextLine()));
                                        break;
                                    case 8:
                                        System.out.println("CAP NHAT HOC VIEN");
                                        System.out.print("Nhập mã người dùng: ");
                                        QuanLyNguoiDung.capNhat(Integer.parseInt(Config.sc.nextLine()));
                                        break;
                                }
                                pause();
                            } while (c != 9);
                        else
                            System.out.println("Bạn không có quyền hạn để truy cập.");
                        break;
                    case 2:
                        do {
                            qlCauHoi();
                            c = nhapLuaChon(5);
                            switch(c) {
                                case 1:
                                    System.out.println("DANH SÁCH CÂU HỎI");
                                    QuanLyCauHoi.hienThi();
                                    break;
                                case 2:
                                    System.out.println("TÌM KIẾM THEO NỘI DUNG");
                                    System.out.println("Nhập nội dung muốn tìm: ");
                                    QuanLyCauHoi.timKiem(Config.sc.nextLine()).forEach(cauHoi -> cauHoi.hienThi());
                                    break;
                                case 3:
                                    System.out.println("TÌM KIẾM THEO DANH MỤC");
                                    Arrays.asList(DanhMuc.values()).forEach(danhMuc -> System.out.println(danhMuc));
                                    QuanLyCauHoi.timKiem(DanhMuc.valueOf(Integer.parseInt(Config.sc.nextLine()))).forEach(cauHoi -> cauHoi.hienThi());
                                    break;
                                case 4:
                                    System.out.println("TÌM KIẾM THEO MỨC ĐỘ");
                                    Arrays.asList(MucDo.values()).forEach(mucDo -> System.out.println(mucDo));
                                    QuanLyCauHoi.timKiem(MucDo.valueOf(Integer.parseInt(Config.sc.nextLine()))).forEach(cauHoi -> cauHoi.hienThi());
                                    break;
                            }
                            pause();
                        } while (c != 5);
                        break;
                    case 3:
                        me.lamBaiLuyenTap();
                        break;
                    case 4:
                        me.thongKeLuyenTap();
                        break;
                }
                pause();
                if(choice == 5)
                    Config.dangNhap=false;
            }
        }
    }

    public static void menu() {
        System.out.println("================ MENU ================");
        System.out.println("1. Quản lý người học");
        System.out.println("2. Quản lý câu hỏi");
        System.out.println("3. Luyện tập");
        System.out.println("4. Thống kê");
        System.out.println("5. Đăng xuất");
    }

    public static void qlNguoiDung(){
        System.out.println("================ MENU ================");
        System.out.println("1. Xem danh sách người dùng.");
        System.out.println("2. Tra cứu học viên theo họ tên.");
        System.out.println("3. Tra cứu học viên theo quê quán.");
        System.out.println("4. Tra cứu học viên theo giới tính.");
        System.out.println("5. Tra cứu học viên theo ngày sinh.");
        System.out.println("6. Thêm học viên.");
        System.out.println("7. Xóa học viên.");
        System.out.println("8. Cập nhật thông tin học viên.");
        System.out.println("9. Quay lại.");
    }
    public static void qlCauHoi() {
        System.out.println("================ MENU ================");
        System.out.println("1. Xem danh sách các câu hỏi.");
        System.out.println("2. Tìm kiếm câu hỏi theo nội dung.");
        System.out.println("3. Tìm kiếm câu hỏi theo danh mục.");
        System.out.println("4. Tìm kiếm câu hỏi theo mức độ.");
        System.out.println("5. Quay Lai");
    }

    public static int nhapLuaChon(int soLuaChon) {
        int choice;
        do {
            System.out.print("Lựa chọn của bạn: ");
            choice = Integer.parseInt(Config.sc.nextLine());
            if(choice <= 0 || choice > soLuaChon)
                System.out.println("Lỗi! vui lòng nhập lại!");
        } while(choice <= 0 || choice > soLuaChon);
        return choice;
    }

    public static void XuatDSND(List<NguoiDung> DS) {
        System.out.println(" _________________________________________________________________________________");
        System.out.println("| ID |     TEN     |  GT  |   DIA CHI   |  NGAY SINH  | NGAY GIA NHAP |  VAI TRO  |");
        DS.forEach(x -> x.hienThi());
        System.out.println("|____|_____________|______|_____________|_____________|_______________|___________|");
    }

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    public static void pause() {
        System.out.println("Nhan ENTER de tiep tuc...");
        Config.sc.nextLine();
    }
}
