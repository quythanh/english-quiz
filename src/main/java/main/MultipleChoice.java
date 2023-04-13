package main;

import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

public class MultipleChoice extends CauHoi {
	private List<PhuongAn> phuongAn;
	private PhuongAn phuongAnDung;
    private PhuongAn luaChon;

    public MultipleChoice() {}

	public MultipleChoice(String noiDung, List<PhuongAn> phuongAn, PhuongAn phuongAnDung) {
        super("1", noiDung, "DANH_TU", 1, "MULTIPLE_CHOICE");
        this.phuongAn = phuongAn;
        this.phuongAnDung = phuongAnDung;
	}

    public PhuongAn getPhuongAnDung() { return this.phuongAnDung; }

    @Override
    public void hienThi() {
        // Hiển thị nội dung câu hỏi
        System.out.println(this.getNoiDung());

        // Hiển thị từng phương án
        for(int i = 0; i < this.phuongAn.size(); i++)
            System.out.printf("%s. %s\n", (char)(i + 65), phuongAn.get(i).getNoiDung());
    }

    public void hienThi(PhuongAn traLoi) {
        this.hienThi();
        System.out.printf(
            "Đáp án của bạn: %s\t\t|| %s ||\nGiải thích: %s\n",
            traLoi.getNoiDung(),
            traLoi == this.phuongAnDung ? "Đúng" : "Sai",
            traLoi.getGiaiThich()
        );
    }

    @Override
    public PhuongAn thucHien() {
        int index;
        this.hienThi();
        do {
            System.out.print("Lua chon dap an cua ban: ");
            char ans = Config.sc.next().charAt(0);
            index = (int)ans - 65;
            if(index < 0 || index >= this.phuongAn.size())
                System.out.println("Loi! vui long nhap lai (A,B,C,D,E...)");
            else 
                this.luaChon = this.phuongAn.get(index);
        } while(index < 0 || index >= this.phuongAn.size());
        return this.phuongAn.get(index);
    }

    @Override
    public void docFile(Scanner sc) {
        String[] info = sc.nextLine().split(",");
        String question = sc.nextLine();
        String[] listAnswers = sc.nextLine().split("#");
        String[] answersInfo = sc.nextLine().split("#");
        sc.nextLine(); // Bỏ qua dòng phân cách

        this.setId(info[0]);
        this.setMucDo(info[1]);
        this.setDangCauHoi(info[2]);
        this.setDanhMuc(info[3]);
        this.setNoiDung(sc.nextLine());
        Arrays.asList(listAnswers).forEach(ans -> this.phuongAn.add(new PhuongAn(ans, answersInfo[1])));
        this.phuongAnDung = new PhuongAn(answersInfo[0], answersInfo[1]);
    }
}
