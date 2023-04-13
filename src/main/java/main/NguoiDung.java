package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class NguoiDung {
	private static int dem;
	private int id;
	private String username;
	private String password;
	private String hoTen;
	private String queQuan;
	private boolean gioiTinh;
	private Calendar ngaySinh;
	private Calendar ngayGiaNhap;
	private List<LuyenTap> baiLuyenTap;

	public NguoiDung(String hoTen, String username, String password, String queQuan, boolean gioiTinh,
			Calendar ngaySinh) {
		this.id = ++dem;
		this.hoTen = hoTen;
		this.queQuan = queQuan;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.ngayGiaNhap = new GregorianCalendar();
		this.baiLuyenTap = new ArrayList<>();

	}

	public String getHoTen() {
		return this.hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public boolean getGioiTinh() {
		return this.gioiTinh;
	}

	public void nhap() {

	}

	public void thongKeLuyenTap() {

	}

	public void lamBaiLuyenTap() {
		Arrays.asList(DangCauHoi.values()).forEach(dch -> System.out.println(dch));
		System.out.println("Chọn dạng câu hỏi:\t");
		// int choice = Integer.parseInt(Config.sc.nextLine());

		// LuyenTap practice = new LuyenTap();

	}

	public List<LuyenTap> getBaiLuyenTap() {
		return this.baiLuyenTap;
	}
}
