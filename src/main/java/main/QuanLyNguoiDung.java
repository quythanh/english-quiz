package main;

import java.util.List;
import java.util.Scanner;
import java.util.Calendar;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class QuanLyNguoiDung {
    private static List<NguoiDung> danhSach = new ArrayList<>();

    static {
        try (Scanner sc = Config.readFile("users/accounts.txt")) {
            while (sc.hasNext()) {
                String[] info = sc.nextLine().split(",");
                Calendar cal = Config.toCalendar(info[5]);
                NguoiDung user = new NguoiDung(info[0], info[1], info[2], info[3], Boolean.parseBoolean(info[4]), cal);
                user.setNgayGiaNhap(Config.toCalendar(info[6]));
                if(info[7].equals("true")) user.setAdmin(true);
                danhSach.add(user);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException ex) {
            Logger.getLogger(QuanLyNguoiDung.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private QuanLyNguoiDung() {}
    
    public static List<NguoiDung> getDanhSach() { return danhSach; }

    public static void hienThi() {
        System.out.println(" _________________________________________________________________________________________");
        System.out.println("| ID |         TEN         |  GT  |   DIA CHI   |  NGAY SINH  | NGAY GIA NHAP |  VAI TRO  |");
        danhSach.forEach(x -> x.hienThi());
        System.out.println("|____|_____________________|______|_____________|_____________|_______________|___________|");
    }

    public static List<NguoiDung> traCuu(String hoTen) {
        return danhSach.stream()
        .filter(nguoiDung -> nguoiDung.getHoTen().contains(hoTen))
        .collect(Collectors.toList());
    }

    public static List<NguoiDung> traCuu(boolean gioiTinh) {
        return danhSach.stream()
        .filter(nguoiDung -> nguoiDung.getGioiTinh() == gioiTinh)
        .collect(Collectors.toList());
    }

    public static List<NguoiDung> traCuu(Calendar ngaySinh) {
        return danhSach.stream()
        .filter(nguoiDung -> nguoiDung.getNgaySinh() == ngaySinh)
        .collect(Collectors.toList());
    }

    public static List<NguoiDung> traCuuTheoQueQuan(String queQuan) {
        return danhSach.stream()
        .filter(nguoiDung -> nguoiDung.getQueQuan().contains(queQuan))
        .collect(Collectors.toList());
    }

    public static void them(NguoiDung nguoiDung) throws ParseException, FileNotFoundException {
        danhSach.add(nguoiDung);
        capNhatDanhSachNguoiDung();
    }

    public static void xoa(int id) throws FileNotFoundException {
        QuanLyNguoiDung.danhSach.removeIf(x -> x.getId() == id);
        capNhatDanhSachNguoiDung();
    }

    public static void capNhat(int id) throws ParseException, FileNotFoundException {
        for(NguoiDung x : QuanLyNguoiDung.danhSach)
        if(x.getId() == id) {
            System.out.println(" _________________________________________________________________________________________");
            System.out.println("| ID |         TEN         |  GT  |   DIA CHI   |  NGAY SINH  | NGAY GIA NHAP |  VAI TRO  |");
            x.hienThi();
            System.out.println("|____|_____________________|______|_____________|_____________|_______________|___________|");
            x.capNhat();
            break;
        }
        capNhatDanhSachNguoiDung();
    }

    private static void capNhatDanhSachNguoiDung() throws FileNotFoundException {
        PrintWriter w = Config.writeFile("users/accounts.txt");
        danhSach.forEach(u -> w.format(
            "%s,%s,%s,%s,%s,%s,%s,%s\n",
            u.getHoTen(),
            u.getUsername(),
            u.getPassword(),
            u.getQueQuan(),
            u.getGioiTinh() ? "true" : "false",
            Config.formatter.format(u.getNgaySinh().getTime()),
            Config.formatter.format(u.getNgayGiaNhap().getTime()),
            u.isAdmin() ? "true" : "false"
        ));
        w.close();
    }

    public static void luuBaiLuyenTap() throws FileNotFoundException {
        PrintWriter w = Config.writeFile("users/exercises.txt");
        for (NguoiDung u : danhSach)
            for (LuyenTap e : u.getBaiLuyenTap())
                w.format(
                    "%s,%s,%.1f,%s\n%s\n==========\n",
                    e.getNguoiDung().getUsername(),
                    e.getDangCauHoi().name(),
                    e.getDiem(),
                    Config.formatter.format(e.getNgayLam().getTime()),
                    String.join(",", e.getDanhSachIdCauHoi())
                );
        w.close();
    }
}
