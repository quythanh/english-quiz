package main;

import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Queue;

public class MultipleChoice extends CauHoi {
	private List<PhuongAn> phuongAn;
	private PhuongAn phuongAnDung;

    public MultipleChoice() {
        this.phuongAn = new ArrayList<>();
    }


    public List<PhuongAn> getPhuongAn() { return phuongAn; }
    public void setPhuongAn(List<PhuongAn> phuongAn) { this.phuongAn = phuongAn; }
    public PhuongAn getPhuongAnDung() { return this.phuongAnDung; }
    public void setPhuongAnDung(PhuongAn phuongAnDung) { this.phuongAnDung = phuongAnDung; }

    @Override
    public void hienThi() {
        // Hiển thị nội dung câu hỏi
        System.out.println(this.getNoiDung());

        // Hiển thị từng phương án
        for(int i = 0; i < this.getPhuongAn().size(); i++)
            System.out.printf("%s. %s\n", (char)(i + 65), getPhuongAn().get(i).getNoiDung());
    }

    @Override
    public void thucHien(Queue<PhuongAn> cauTraLoi) {
        int index;
        this.hienThi();
        do {
            System.out.print("Lựa chọn đáp án của bạn: ");
            char ans = Config.sc.nextLine().charAt(0);
            index = (int)ans - 65;
            if(index < 0 || index >= this.getPhuongAn().size())
                System.out.println("Lỗi! Vui lòng nhập lai (A,B,C,D,...)");
        } while(index < 0 || index >= this.getPhuongAn().size());
        cauTraLoi.add(this.getPhuongAn().get(index));
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
        this.setNoiDung(question);
        Arrays.asList(listAnswers).forEach(ans -> this.getPhuongAn().add(new PhuongAn(ans, answersInfo[1])));
        for (var opt : this.getPhuongAn())
            if (opt.getNoiDung().equals(answersInfo[0])) {
                this.setPhuongAnDung(opt);
                break;
            }
    }

    @Override
    public int getKetQua(Queue<PhuongAn> ans) {
        this.hienThi();
        PhuongAn traLoi = ans.poll();
        boolean kq = traLoi == this.getPhuongAnDung();
        System.out.printf("Đáp án của bạn: %s\t\t|| %s ||\nGiải thích: %s\n\n",
            traLoi.getNoiDung(),
            kq ? "Đúng" : "Sai",
            traLoi.getGiaiThich()
        );
        return kq ? 1 : 0;
    }
}
