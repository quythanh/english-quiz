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
//        List<CauHoi> l = QuanLyCauHoi.getDanhSach(DangCauHoi.CONVERSATION);
        //List<PhuongAn> cauTraLoi = new ArrayList<>();
//        l.forEach(q -> q.hienThi());
        //for (int i = 0; i < l.size(); i++)
          //  l.get(i).hienKetQua(cauTraLoi.get(i));
          
          try (Scanner sc = Config.readFile("questions/conversation.txt")) {
			while (sc.hasNextLine()) {
//				CauHoi cauHoi = new Conversation();
//				cauHoi.docFile(sc);
//                                cauHoi.hienThi();
                        System.out.println(sc.nextLine());
			}
                sc.close();
		} catch (FileNotFoundException e) {

    }
}
}
