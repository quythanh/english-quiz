package main;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

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
        List<CauHoi> l = QuanLyCauHoi.getDanhSach(DangCauHoi.MULTIPLE_CHOICE);
        List<PhuongAn> a = new ArrayList<>();
        l.forEach(q -> a.add(q.thucHien().get(0)));
        for (int i = 0; i < l.size(); i++)
            l.get(i).hienKetQua(a.get(i));
    }
}
