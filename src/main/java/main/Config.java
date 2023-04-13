package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Config {
    public static final SimpleDateFormat fomatter = new SimpleDateFormat("dd/MM/yyyy");
    public static final Scanner sc = new Scanner(System.in);

    public static Scanner readFile(String path) throws FileNotFoundException {
        final String baseDir = "src/main/resources";
        File file = new File(baseDir + "/" + path);
        return new Scanner(file);
    }
}
