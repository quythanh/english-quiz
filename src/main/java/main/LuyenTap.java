package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class LuyenTap {
    private NguoiDung nguoiDung;
    private DangCauHoi dangCauHoi;
    private double diem;
    private Calendar ngayLam;
    private List<String> danhSachIdCauHoi = new ArrayList<>();

    public LuyenTap(NguoiDung nguoiDung, DangCauHoi dangCauHoi) {
        this.nguoiDung = nguoiDung;
        this.dangCauHoi = dangCauHoi;
        this.ngayLam = new GregorianCalendar();
        
        List<CauHoi> danhSach = QuanLyCauHoi.getDanhSach(dangCauHoi);
        Queue<PhuongAn> cauTraLoi = new LinkedList<>();
        List<String> IdCauHoiDaLam = new ArrayList<>();

        for (LuyenTap lt : nguoiDung.getBaiLuyenTap())
            if (lt.getDangCauHoi() == dangCauHoi)
                IdCauHoiDaLam.addAll(lt.getDanhSachIdCauHoi());
        List<CauHoi> cauHoi = danhSach.stream().filter(q -> !IdCauHoiDaLam.contains(q.getId())).collect(Collectors.toList());

        int s = dangCauHoi.getSoLuong();
        for (int i = 0; i < s; i++) {
            CauHoi q = cauHoi.get(i);
            danhSachIdCauHoi.add(q.getId());
            q.thucHien(cauTraLoi);
        }

        int soCauDung = 0, soCauHoi = cauTraLoi.size();
        for (int i = 0; i < s; i++)
            soCauDung += cauHoi.get(i).getKetQua(cauTraLoi);
        this.diem = soCauDung * 10.0 / soCauHoi;
        System.out.printf("Điểm: %.2f\n", this.diem);
    }

    public LuyenTap(NguoiDung nguoiDung, DangCauHoi dangCauHoi, double diem, Calendar ngayLam, List<String> danhSachIdCauHoi) {
        this.nguoiDung = nguoiDung;
        this.dangCauHoi = dangCauHoi;
        this.diem = diem;
        this.ngayLam = ngayLam;
        this.danhSachIdCauHoi = danhSachIdCauHoi;
    }

    public NguoiDung getNguoiDung() { return this.nguoiDung; }
    public Calendar getNgayLam() { return this.ngayLam; }
    public double getDiem() { return this.diem; }
    public DangCauHoi getDangCauHoi() { return this.dangCauHoi; }
    public List<String> getDanhSachIdCauHoi() { return this.danhSachIdCauHoi; }
}
