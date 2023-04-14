package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class LuyenTap {
    private DangCauHoi dangCauHoi;
    private NguoiDung nguoiDung;
    private double diem;
    private Calendar ngayLam;
    private List<CauHoi> cauHoi = new ArrayList<>();

    public LuyenTap(DangCauHoi dangCauHoi, NguoiDung nguoiDung) {
        this.dangCauHoi = dangCauHoi;
        this.nguoiDung = nguoiDung;
        this.ngayLam = new GregorianCalendar();
        
        List<CauHoi> danhSach = QuanLyCauHoi.getDanhSach(dangCauHoi);
        //List<LuyenTap> danhSachLuyenTap = nguoiDung.getBaiLuyenTap();
        Queue<PhuongAn> cauTraLoi = new LinkedList<>();

        //for (CauHoi quest : )
            //for (LuyenTap luyenTap : danhSachLuyenTap)
                //if (!luyenTap.getCauHoi().contains(cauHoi) && cauHoi.getMucDo() == dangCauHoi.getMucDo())
         //           danhSach.add(quest);

        int s = dangCauHoi.getSoLuong();

        for (int i = 0; i < s; i++) {
            CauHoi q = danhSach.get(i);
            cauHoi.add(q);
            q.thucHien(cauTraLoi);
        }
        int soCauDung = 0, soCauHoi = cauTraLoi.size();
        for (int i = 0; i < this.cauHoi.size(); i++)
            soCauDung += this.cauHoi.get(i).getKetQua(cauTraLoi);
        this.diem = soCauDung * 10.0 / soCauHoi;
        System.out.printf("Điểm: %.2f\n", this.diem);
    }

    public double getDiem() {
        return 0;
    }

    public List<CauHoi> getCauHoi() {
        return this.cauHoi;
    }

}
