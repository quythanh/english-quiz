package main;

import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //menu();
        test();
    }

    public static void menu() {
        System.out.println("================ MENU ================");
        System.out.println("1. Quản lý người học");
        System.out.println("2. Quản lý câu hỏi");
        System.out.println("3. Luyện tập");
        System.out.println("4. Thoát");
    }

    public static void test() {
       //PhuongAn A = new PhuongAn("It's an apple", "just an apple");
       //PhuongAn B = new PhuongAn("It's an pineapple", "just an apple");
       //PhuongAn C = new PhuongAn("It's an banana", "just an apple");
       //PhuongAn D = new PhuongAn("It's an burger", "just an apple");
       //List<PhuongAn> Ans = new ArrayList<>();
       //Ans.add(A);
       //Ans.add(B);
       //Ans.add(C);
       //Ans.add(D);
       //CauHoi C1 = new MultipleChoice("what is it?", Ans, A);
       //PhuongAn a = C1.thucHien();
       //String kq = "Sai";
       //if (a == C1.getPhuongAnDung())
       //    kq = "Đúng";
       //C1.hienThi();
        List<CauHoi> l = QuanLyCauHoi.getDanhSach(DangCauHoi.MULTIPLE_CHOICE);
        l.forEach(q -> {
            PhuongAn a = q.thucHien();
            String kq = "Sai";
            if (a == q.getPhuongAnDung())
                kq = "Đúng";
            q.hienThi();
        });
    }
}
