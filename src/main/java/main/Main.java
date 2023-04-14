package main;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

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
        Queue<PhuongAn> a = new LinkedList<>();
        List<CauHoi> l = QuanLyCauHoi.getDanhSach(DangCauHoi.CONVERSATION);
        l.forEach(q -> q.thucHien(a));
        l.forEach(q -> q.hienKetQua(a));
    }
}
