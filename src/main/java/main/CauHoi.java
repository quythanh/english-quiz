package main;

import java.util.Objects;
import java.util.Scanner;
import java.util.Queue;

public abstract class CauHoi {
	private String id;
	private String noiDung;
	private DanhMuc danhMuc;
	private MucDo mucDo;
	private DangCauHoi dangCauHoi;

	public CauHoi() {
	}

	public CauHoi(String id, String noiDung, String danhMuc, int mucDo, String dangCauHoi) {
		this.id = id;
		this.noiDung = noiDung;
		this.danhMuc = DanhMuc.valueOf(danhMuc);
		this.mucDo = MucDo.valueOf(mucDo);
		this.dangCauHoi = DangCauHoi.valueOf(dangCauHoi);
	}

    public String getId() { return this.id; }
    public void setId(String id) { this.id = id; }
    public String getNoiDung() { return this.noiDung; }
    public void setNoiDung(String noiDung) { this.noiDung = noiDung; }
    public DanhMuc getDanhMuc() { return this.danhMuc; }
    public void setDanhMuc(DanhMuc danhMuc) { this.danhMuc = danhMuc; }
    public void setDanhMuc(String danhMuc) { this.danhMuc = DanhMuc.valueOf(danhMuc); }
    public MucDo getMucDo() { return this.mucDo; }
    public void setMucDo(MucDo mucDo) { this.mucDo = mucDo; }
    public void setMucDo(String mucDo) { this.mucDo = MucDo.valueOf(mucDo); }
    public DangCauHoi getDangCauHoi() { return this.dangCauHoi; }
    public void setDangCauHoi(DangCauHoi dangCauHoi) { this.dangCauHoi = dangCauHoi; }
    public void setDangCauHoi(String dangCauHoi) { this.dangCauHoi = DangCauHoi.valueOf(dangCauHoi); }
    public PhuongAn getPhuongAnDung() { return null; }

    @Override
    public boolean equals(Object object) {
        return this.id == ((CauHoi) object).id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
        return hash;
    }

    public abstract void hienThi();
    public abstract void thucHien(Queue<PhuongAn> cauTraLoi);
    public abstract void docFile(Scanner sc);
    public abstract int getKetQua(Queue<PhuongAn> ans);
}
