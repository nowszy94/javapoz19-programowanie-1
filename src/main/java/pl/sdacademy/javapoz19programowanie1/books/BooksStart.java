package pl.sdacademy.javapoz19programowanie1.books;

import java.util.List;
import java.util.Scanner;

public class BooksStart {

    private BooksViews views;
    private AuthorsRepository authorsRepository;
    private BooksService booksService;

    public BooksStart() {
        this.views = new BooksViews(new Scanner(System.in));
        this.authorsRepository = new InMemoryAuthorsRepository();
        this.booksService = new BooksService(new InMemoryBooksRepository(authorsRepository));
    }

    public void start() {
        boolean flag = true;
        do {
            int decision = views.startMenu();
            switch (decision) {
                case 1:
                    authorsView();
                    break;
                case 2:
                    booksView();
                    break;
                default:
                    flag = false;
            }
        } while (flag);
    }

    private void authorsView() {
        boolean flag = true;
        List<Author> authors = authorsRepository.findAll();
        do {
            int decision = views.authorsMenu(authors);

            switch (decision) {
                case 1: // findByNation
                    Nation nation = views.getNation();
                    authors = authorsRepository.findByNation(nation);
                    break;
                case 2: //findAfterBirthYear
                    int birthYear = views.getBirthYear();
                    authors = authorsRepository.findAfterBirthYear(birthYear);
                    break;
                default:
                    flag = false;
            }

        } while (flag);
    }

    private void booksView() {
        boolean flag = true;
        List<Book> books = booksService.findAll();
        do {
            int decision = views.booksMenu(books);
            switch (decision) {
                case 1:
                    // 1. Find by after releaseYear
                    int releaseYear = views.getReleaseYear();
                    books = booksService.findByAfterReleaseYear(releaseYear);
                    break;
                case 2:
                    String phrase = views.getPhrase();
                    books = booksService.searchByPhrase(phrase);
                    break;
                case 3:
                    String authorPhrase = views.getPhrase();
                    books = booksService.searchByAuthor(authorPhrase);
                    break;
                default:
                    flag = false;
            }
        } while (flag);
    }
}








