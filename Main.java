//1. Напишите метод, который принимает на вход строку (String) и определяет
// является ли строка палиндромом (возвращает boolean значение).
//2. Напишите метод, который составит строку, состоящую из 100 повторений слова
// TEST и метод, который запишет эту строку в простой текстовый файл, обработайте
// исключения.

package home_work2;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //task1();
        task2();
    }

    private static void task2() {
        String text = textGenerate("TEST", 100);
        printFile(text);
    }

    private static void printFile(String text) {

        try (PrintWriter pw = new PrintWriter(new File("File.txt").getAbsoluteFile())) {
            pw.print(text);
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static String textGenerate(String str, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(str).append(" ");
        }      return sb.toString();
    }

    private static void task1() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter phrase: ");
        String str = scan.nextLine();
        System.out.println(isPolindrom(str) ? "Polindrom" : "Not polindrom");
    }

    private static boolean isPolindrom(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}

