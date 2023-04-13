package main;

import java.util.Scanner;

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

    @Override
    public boolean equals(Object object) {
        return this.id == ((CauHoi) object).id;
    }

    public PhuongAn getPhuongAnDung() { return null; }

	public abstract void hienThi();
	public abstract PhuongAn thucHien();
    public abstract void docFile(Scanner sc);
}
