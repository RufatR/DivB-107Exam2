package utils;

import java.util.Scanner;

public class InputUtil {
    public static int Inputint(String title){
        Scanner rr = new Scanner(System.in);
        System.out.print(title);
        return rr.nextInt();
    }

    public static String InputString(String title){
        Scanner rr = new Scanner(System.in);
        System.out.print(title);
        return rr.nextLine();
    }
}
