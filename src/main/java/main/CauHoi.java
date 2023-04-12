package main;

public abstract class CauHoi {
	private String noiDung;
	private DanhMuc danhMuc;
	private MucDo mucDo;
	private DangCauHoi dangCauHoi;

	public CauHoi() {
	}

	public CauHoi(String noiDung, String danhMuc, int mucDo, String dangCauHoi) {
		this.noiDung = noiDung;
		this.danhMuc = DanhMuc.valueOf(danhMuc);
		this.mucDo = MucDo.valueOf(mucDo);
		this.dangCauHoi = DangCauHoi.valueOf(dangCauHoi);
	}

	public String getnoiDung() {
		return this.noiDung;
	}

	public DanhMuc getDanhMuc() {
		return this.danhMuc;
	}

	public MucDo getMucDo() {
		return this.mucDo;
	}

	public DangCauHoi getDangCauHoi() {
		return this.dangCauHoi;
	}

	public void hienThi() {
		System.out.println(this.noiDung);
	}
}
