package main;

import java.util.List;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Scanner;

public class QuanLyCauHoi {
	private static List<CauHoi> danhSach = new ArrayList<>();

	static {
		try (Scanner sc = Config.readFile("questions/multiple_choice.txt")) {
			while (sc.hasNext()) {
				CauHoi cauHoi = new MultipleChoice();
				cauHoi.docFile(sc);
				danhSach.add(cauHoi);
			}
            sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// sc = Config.readFile("questions/incomplete.txt");
		// while (sc.hasNext()) {
		// CauHoi cauHoi = new Incomplete();
		// cauHoi.docFile(sc);
		// danhSach.add(cauHoi);
		// }
		//
		// sc = Config.readFile("questions/conversation.txt");
		// while (sc.hasNext()) {
		// CauHoi cauHoi = new Conversation();
		// cauHoi.docFile(sc);
		// danhSach.add(cauHoi);
		// }
	}

	private QuanLyCauHoi() {
	}

	public static List<CauHoi> getDanhSach() {
		return danhSach;
	}

	public static List<CauHoi> getDanhSach(DangCauHoi dangCauHoi) {
		return danhSach.stream()
				.filter(cauHoi -> cauHoi.getDangCauHoi() == dangCauHoi)
				.collect(Collectors.toList());
	}

	public static List<CauHoi> timKiem(String noiDung) {
		return danhSach.stream()
				.filter(cauHoi -> cauHoi.getNoiDung().contains(noiDung))
				.collect(Collectors.toList());
	}

	public static List<CauHoi> timKiem(MucDo mucDo) {
		return danhSach.stream()
				.filter(cauHoi -> cauHoi.getMucDo() == mucDo)
				.collect(Collectors.toList());
	}

	public static List<CauHoi> timKiem(DanhMuc danhMuc) {
		return danhSach.stream()
				.filter(cauHoi -> cauHoi.getDanhMuc() == danhMuc)
				.collect(Collectors.toList());
	}
}
