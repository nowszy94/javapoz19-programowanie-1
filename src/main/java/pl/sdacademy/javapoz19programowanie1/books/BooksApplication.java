package pl.sdacademy.javapoz19programowanie1.books;

import java.io.File;
import java.util.Scanner;

public class BooksApplication {
    public static void main(String[] args) {
//        new BooksStart().start();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Insert number");
        int someNumber = scanner.nextInt();

        System.out.println("insert name");
        String name = scanner.nextLine();

        System.out.println("name: " + name);
    }
}
