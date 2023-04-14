package main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum DanhMuc {
	DANH_TU(1, "Danh từ"),
	TINH_TU(2, "Tính từ"),
	DONG_TU(3, "Động từ"),
	TRANG_TU(4, "Trạng từ"),
        DOAN_VAN(5,"Đoạn văn");

	private int id;
	private String name;
	private static Map<Integer, DanhMuc> map = new HashMap<>();

	static {
		Arrays.asList(DanhMuc.values()).forEach(danhMuc -> map.put(danhMuc.id, danhMuc));
	}

	private DanhMuc(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("%d. %s", this.id, this.name);
	}

	public static DanhMuc valueOf(int id) {
		return map.get(id);
	}
}
