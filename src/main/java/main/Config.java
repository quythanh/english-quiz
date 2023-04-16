package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Config {
    public static final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    public static final Scanner sc = new Scanner(System.in);
    public static boolean dangNhap = false;
    private static final String baseDir = "src/main/resources";

    public static Scanner readFile(String path) throws FileNotFoundException {
        File file = new File(baseDir + "/" + path);
        return new Scanner(file);
    }

    public static PrintWriter writeFile(String path) throws FileNotFoundException {
        File file = new File(baseDir + "/" + path);
        return new PrintWriter(file);
    }
    
    public static Calendar toCalendar(String date) throws ParseException{
        Calendar cal = Calendar.getInstance();
        cal.setTime(formatter.parse(date));
        return cal;
    }
}
