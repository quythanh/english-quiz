package mser;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class NguoiDung {
    private static int dem;
    private int id = ++dem;
    private String hoTen;
    private String queQuan;
    private boolean gioiTinh;
    private Calendar ngaySinh;
    private Calendar ngayGiaNhap;

    public NguoiDung(int id, String hoTen, String queQuan, boolean gioiTinh, Calendar ngaySinh) {
        this.hoTen = hoTen;
        this.queQuan = queQuan;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.ngayGiaNhap = new GregorianCalendar();
    }
}
