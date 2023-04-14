package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class LuyenTap {
    private DangCauHoi dangCauHoi;
    private NguoiDung nguoiDung;
    private double diem;
    private Calendar ngayLam;
    private List<CauHoi> cauHoi;

    public LuyenTap(DangCauHoi dangCauHoi, NguoiDung nguoiDung) {
        this.dangCauHoi = dangCauHoi;
        this.nguoiDung = nguoiDung;
        this.ngayLam = new GregorianCalendar();

        List<CauHoi> danhSach = new ArrayList<>();
        List<LuyenTap> danhSachLuyenTap = nguoiDung.getBaiLuyenTap();
        PhuongAn[] cauTraLoi;

        for (CauHoi cauHoi : QuanLyCauHoi.getDanhSach(dangCauHoi))
            for (LuyenTap luyenTap : danhSachLuyenTap)
                if (!luyenTap.getCauHoi().contains(cauHoi) && cauHoi.getMucDo() == dangCauHoi.getMucDo())
                    danhSach.add(cauHoi);

        for (int i = 0; i < dangCauHoi.getSoLuong(); i++) {
            CauHoi q = danhSach.get(i);
            cauHoi.add(q);
            q.thucHien(cauTraLoi);
        }
        cauHoi.forEach(x -> x.hienKetQua(CauTraLoi);
    }

    public double getDiem() {
        return 0;
    }

    public List<CauHoi> getCauHoi() {
        return this.cauHoi;
    }

}
