package main;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class NguoiDung {
    public static int dem;
    private int id;
    private String username;
    private String password;
    private String hoTen;
    private String queQuan;
    private boolean gioiTinh;
    private Calendar ngaySinh;
    private Calendar ngayGiaNhap;
    private List<LuyenTap> baiLuyenTap;
    private boolean admin;

    public NguoiDung() {
        this.baiLuyenTap = new ArrayList<>();
    }

    public NguoiDung(String hoTen, String username, String password, String queQuan, boolean gioiTinh,
        Calendar ngaySinh) {
        this.id = ++dem;
        this.hoTen = hoTen;
        this.username = username;
        this.password = password;
        this.queQuan = queQuan;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.ngayGiaNhap = new GregorianCalendar();
        this.baiLuyenTap = new ArrayList<>();

        try (Scanner sc = Config.readFile("users/exercises.txt")) {
            while (sc.hasNext()) {
                String[] info = sc.nextLine().split(",");
                String[] listId = sc.nextLine().split(",");
                sc.nextLine();

                if (this.username.equals(info[0]))
                this.baiLuyenTap.add(
                    new LuyenTap(this, DangCauHoi.valueOf(info[1]), Double.parseDouble(info[2]), Config.toCalendar(info[3]), Arrays.asList(listId))
                );
            }
            sc.close();
        } catch (FileNotFoundException e) {

        } catch (ParseException e1) {

        }
    }

    public void hienThi(){
        String role = this.isAdmin() ? "ADMIN" : "HOC VIEN";
        String birth = Config.formatter.format(this.getNgaySinh().getTime());
        String join = Config.formatter.format(this.getNgayGiaNhap().getTime());
        System.out.println("|____|_____________________|______|_____________|_____________|_______________|___________|");
        System.out.println("|    |                     |      |             |             |               |           |");
        System.out.printf("| %2d | %19s | %4s | %11s | %11s | %13s | %9s |\n", this.getId(), this.hoTen, this.gioiTinh ? "Nam" : "Nu", this.getQueQuan(), birth, join, role);
    }

    private void nhap() throws ParseException {
        System.out.print("(-) Họ và tên: ");
        this.hoTen = Config.sc.nextLine();
        System.out.print("(-) Gioi Tinh: ");
        this.gioiTinh = Config.sc.nextLine().toUpperCase().equals("NAM");
        System.out.print("(-) Que Quan: ");
        this.queQuan = Config.sc.nextLine();
        System.out.print("(-) Ngày sinh: ");
        this.ngaySinh=Config.toCalendar(Config.sc.nextLine());
    }

    public void dangKi() throws ParseException {
        this.id = ++dem;
        System.out.print("(-) Username: ");
        boolean acceptable;
        do {
            acceptable = true;
            this.username = Config.sc.nextLine();
            for (NguoiDung u : QuanLyNguoiDung.getDanhSach()) {
                if (u.getUsername().equals(this.username)) {
                    System.out.print("Tên đăng nhập đã được sử dụng. Vui lòng nhập lại: ");
                    acceptable = false;
                    break;
                }
            }
        } while (!acceptable);
        System.out.print("(-) Password: ");
        this.password = Config.sc.nextLine();
        this.nhap();
        this.ngayGiaNhap = new GregorianCalendar();
        this.admin = false;
    }

    public void capNhat() throws ParseException {
        this.nhap();
        System.out.print("(-) Ngày giá nhập: ");
        this.ngayGiaNhap = Config.toCalendar(Config.sc.nextLine());
    }

    public void thongKeLuyenTap() {
        int thang = -1;
        int nam = -1;
        int soBaiLT = 0;
        double trungBinh = 0;
        for (LuyenTap lt : this.baiLuyenTap) {
            if (thang != lt.getNgayLam().get(Calendar.MONTH) || nam != lt.getNgayLam().get(Calendar.YEAR)) {
                if (soBaiLT != 0)
                System.out.printf("Số lần làm bài: %d\nĐiểm trung bình: %.1f\n", soBaiLT, trungBinh / soBaiLT);
                soBaiLT = 0;
                trungBinh = 0;
                thang = lt.getNgayLam().get(Calendar.MONTH);
                nam = lt.getNgayLam().get(Calendar.YEAR);
                System.out.printf("Tháng %d năm %d:\n", thang + 1, nam);

            }
            trungBinh += lt.getDiem();
            System.out.printf("\tLần %d: %.1f\n", ++soBaiLT, lt.getDiem());
            if (lt.equals(this.baiLuyenTap.get(this.baiLuyenTap.size() - 1)))
            System.out.printf("Số lần làm bài: %d\nĐiểm trung bình: %.1f\n", soBaiLT, trungBinh / soBaiLT);
        }
    }

    public void lamBaiLuyenTap() throws FileNotFoundException {
        Arrays.asList(DangCauHoi.values()).forEach(dch -> System.out.println(dch));
        System.out.println("Chọn dạng câu hỏi:\t");
        int choice = Integer.parseInt(Config.sc.nextLine());

        LuyenTap practice = new LuyenTap(this, DangCauHoi.valueOf(choice));
        this.baiLuyenTap.add(practice);
        QuanLyNguoiDung.luuBaiLuyenTap();
    }        

    public String getHoTen() {
        return this.hoTen;
    }
    public String getPassword(){
        return this.password;
    }
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
    public boolean getGioiTinh() {
        return this.gioiTinh;
    }
    public List<LuyenTap> getBaiLuyenTap() {
        return this.baiLuyenTap;
    }    
    public void setNgayGiaNhap(Calendar s){
        this.ngayGiaNhap = s;
    }    
    public void setAdmin(boolean b){
        this.admin = b;
    }
    public int getId() {
        return id;
    }
    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getQueQuan() {
        return queQuan;
    }
    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }
    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
    public Calendar getNgaySinh() {
        return ngaySinh;
    }
    public void setNgaySinh(Calendar ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    public Calendar getNgayGiaNhap() {
        return ngayGiaNhap;
    }
    public boolean isAdmin() {
        return admin;
    }
}

