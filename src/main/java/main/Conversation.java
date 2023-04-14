package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Conversation extends CauHoi {

	private List<MultipleChoice> cauHoi;

	public Conversation() {
            this.cauHoi = new ArrayList<>();
	}
	@Override
	public void hienThi() {
            System.out.println(this.getNoiDung());
            this.cauHoi.forEach(x -> x.hienThi());
	}

	@Override
	public void thucHien(List<PhuongAn> cauTraLoi) {
            System.out.println(this.getNoiDung());
            this.cauHoi.forEach(x -> x.thucHien(cauTraLoi));
	}

	@Override
	public void docFile(Scanner sc) {
            String[] info = sc.nextLine().split(",");
            this.setId(info[0]);
            this.setMucDo(info[1]);
            this.setDangCauHoi(info[2]);
            this.setDanhMuc(info[3]);
            String marker, doanVan = new String();
            do{
                marker = sc.nextLine() + "\n";
                if(!marker.contains("#"))
                    doanVan = doanVan.concat(marker);
            }while(!marker.contains("#"));
            this.setNoiDung(doanVan);
            
        }

    @Override
    public void hienKetQua(PhuongAn... ans) {
        
    }
}
