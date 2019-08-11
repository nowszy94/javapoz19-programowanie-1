package pl.sdacademy.javapoz19programowanie1.books;

import java.util.List;

public interface BooksRepository {
    List<Book> findAll();

    List<Book> findByAfterReleaseYear(int releaseYear);

    List<Book> searchByPhrase(String phrase);
}
