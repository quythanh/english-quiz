package main;

import java.util.List;
import java.util.Scanner;
import java.util.Calendar;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class QuanLyNguoiDung {
	private static List<NguoiDung> danhSach = new ArrayList<>();

	static {
		try (Scanner sc = Config.readFile("users/accounts.txt")) {
			while (sc.hasNext()) {

			}
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private QuanLyNguoiDung() {
	}

	public void hienThi() {

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
		return null;
	}

	public static List<NguoiDung> traCuuTheoQueQuan(String queQuan) {
		return null;
	}

	public void them(NguoiDung nguoiDung) {

	}

	public void xoa(int id) {

	}

	public void capNhat(int id) {

	}
}
