package main;

import java.util.List;
import java.util.Scanner;

public class Conversation extends CauHoi {

	private List<MultipleChoice> cauHoi;

	public Conversation() {

	}

	@Override
	public void hienThi() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'hienThi'");
	}

	@Override
	public void thucHien(List<PhuongAn> cauTraLoi) {
		return null;
	}

	@Override
	public void docFile(Scanner sc) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'docFile'");
	}

    @Override
    public void hienKetQua(PhuongAn... ans) {}
}
