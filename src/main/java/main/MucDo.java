package main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum MucDo {
	DE(1, "Dễ"),
	TRUNG_BINH(2, "Trung bình"),
	KHO(3, "Khó");

	private int id;
	private String name;
	private static Map<Integer, MucDo> map = new HashMap<>();

	static {
		Arrays.asList(MucDo.values()).forEach(mucDo -> map.put(mucDo.id, mucDo));
	}

	private MucDo(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("%d. %s", this.id, this.name);
	}

	public static MucDo valueOf(int id) {
		return map.get(id);
	}
}
