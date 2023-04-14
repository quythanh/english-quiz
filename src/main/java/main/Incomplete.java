package main;

import java.util.List;
import java.util.Scanner;
import java.util.Queue;

public class Incomplete extends CauHoi {

	private List<MultipleChoice> cauHoi;

	public Incomplete() {}

	@Override
	public void hienThi() {
        System.out.println(this.getNoiDung());
	}

	@Override
	public void thucHien(Queue<PhuongAn> cauTraLoi) {
	}

    @Override
    public void docFile(Scanner sc) {}

    @Override
    public void hienKetQua(Queue<PhuongAn> ans) {}
}
