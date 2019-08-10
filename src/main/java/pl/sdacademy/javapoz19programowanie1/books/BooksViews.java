package pl.sdacademy.javapoz19programowanie1.books;

import java.util.List;
import java.util.Scanner;

public class BooksViews {
    private Scanner scanner;

    public BooksViews(Scanner scanner) {
        this.scanner = scanner;
    }

    public int startMenu() {
        System.out.println("1. Authors");
        System.out.println("2. Books");
        System.out.println("0. Koniec");
        return getDecisionAfterEnter();
    }

    public int authorsMenu(List<Author> authors) {
        authors.stream()
                .forEach(author -> System.out.println(author));
        System.out.println();
        System.out.println("1. Find by nation (PL, ENG, USA)");
        System.out.println("2. Find by after birthYear");
        System.out.println("0. Wroc");
        return getDecision();
    }

    public int getDecision() {
        return scanner.nextInt();
    }

    public Nation getNation() {
        String nationAsString = scanner.nextLine().trim();
        return Nation.valueOf(nationAsString);
    }

    public int getBirthYear() {
        String birthYearAsString = scanner.nextLine().trim();
        return Integer.valueOf(birthYearAsString);
    }

    private int getDecisionAfterEnter() {
        int menu = scanner.nextInt();
        scanner.nextLine();
        return menu;
    }

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Hello Whats your name?");
//        String name = scanner.nextLine();
//        System.out.println("Hello " + name);
//        System.out.println("How old are you");
//        int age = scanner.nextInt();
//        scanner.nextLine();
//        System.out.println("Your age is " + age);
//        System.out.println("Are you happy (yes/no)");
//        System.out.println("Status: " + scanner.nextLine());
//
//        String message = "My name is Szymon Nowak\n I work in allegro";
//
//        Scanner scannerString = new Scanner(message);
//    }
}









