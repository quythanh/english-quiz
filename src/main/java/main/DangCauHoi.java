package main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum DangCauHoi {
	MULTIPLE_CHOICE(1, "Multiple choice") {
        @Override
        public int getSoLuong() {
            System.out.println("Nhập số lượng câu: ");
            return Integer.parseInt(Config.sc.nextLine());
        }

        @Override
        public MucDo getMucDo() {
            return MucDo.valueOf((int)(Math.random() * MucDo.values().length));
        }
    },
	INCOMPLETE(2, "Incomplete"),
	CONVERSATION(3, "Conversation");

	private int id;
	private String name;
	private static Map<Integer, DangCauHoi> map = new HashMap<>();

	static {
		Arrays.asList(DangCauHoi.values()).forEach(dch -> map.put(dch.id, dch));
	}

	private DangCauHoi(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("%d. %s", this.id, this.name);
	}

	public static DangCauHoi valueOf(int id) {
		return map.get(id);
	}

    public int getSoLuong() {
        return 1;
    }

    public MucDo getMucDo() {
        Arrays.asList(DangCauHoi.values()).forEach(dch -> System.out.println(dch));
        System.out.println("Chọn mức độ câu hỏi:\t");
        int choice = Integer.parseInt(Config.sc.nextLine());
        return MucDo.valueOf(choice);
    }
}
