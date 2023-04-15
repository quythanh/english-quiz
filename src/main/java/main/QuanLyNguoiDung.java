package main;

import java.util.List;
import java.util.Scanner;
import java.util.Calendar;
import java.io.FileNotFoundException;
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException ex) {
                Logger.getLogger(QuanLyNguoiDung.class.getName()).log(Level.SEVERE, null, ex);
            }
	} 

	public static void hienThi() {
            System.out.println(" _________________________________________________________________________________");
            System.out.println("| ID |     TEN     |  GT  |   DIA CHI   |  NGAY SINH  | NGAY GIA NHAP |  VAI TRO  |");
            danhSach.forEach(x -> x.hienThi());
            System.out.println("|____|_____________|______|_____________|_____________|_______________|___________|");
	}
        public static NguoiDung dangNhap(){
            System.out.print("Nhap username: ");
            String name = Config.sc.nextLine();
            System.out.print("Nhap mat khau: ");
            String pass = Config.sc.nextLine();
            for(int i =0; i<danhSach.size(); i++)
            {
                if(danhSach.get(i).getUsername().equals(name) && danhSach.get(i).getPassword().equals(pass)){
                    Config.dangNhap = true;
                    return danhSach.get(i);
                }
            }
            System.out.println("Ten nguoi dung khong ton tai hoac mat khau khong dung!");
            return null;
        }
        
        public static NguoiDung dangKi() throws ParseException{
            NguoiDung dk = new NguoiDung();
            dk.dangKi();
            QuanLyNguoiDung.danhSach.add(dk);
            Config.dangNhap = true;
            return dk;
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

	public static void them() throws ParseException {
            NguoiDung moi = QuanLyNguoiDung.dangKi();
	}

	public static void xoa(int id) {
            QuanLyNguoiDung.danhSach.removeIf(x -> x.getId() == id);
	}

	public static void capNhat(int id) throws ParseException {
            for(NguoiDung x : QuanLyNguoiDung.danhSach)
            {
                if(x.getId()==id){
                    x.capNhat();
                    break;
                }
            }
	}
}
