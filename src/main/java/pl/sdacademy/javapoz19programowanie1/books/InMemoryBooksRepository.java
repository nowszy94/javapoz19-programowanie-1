package pl.sdacademy.javapoz19programowanie1.books;

import pl.sdacademy.javapoz19programowanie1.Pet.InMemoryPetRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InMemoryBooksRepository implements BooksRepository {
    private List<Book> books;
    private AuthorsRepository authorsRepository;

    public InMemoryBooksRepository(AuthorsRepository authorsRepository) {
        this.authorsRepository = authorsRepository;
        init();
    }

    private void init() {
        List<Author> authors = authorsRepository.findAll();
        this.books = Arrays.asList(
                new Book("W pustyni i w puszczy", 1910, 300, authors.get(1)),
                new Book("Krzyżacy", 1900, 1000, authors.get(1)),
                new Book("Dziady III", 1832, 250, authors.get(2)),
                new Book("Dziady I", 1860, 350, authors.get(2)),
                new Book("Zielona mila", 1996, 290, authors.get(0)),
                new Book("Balladyn", 1839, 400, authors.get(3)),
                new Book("Harry Potter i Czara ognia", 2005, 650, authors.get(4)),
                new Book("Harry Potter i Ksiaze Polkrwi", 2009, 800, authors.get(4)),
                new Book("Romeo i Julia", 1595, 34, authors.get(5))
        );
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(books);
    }

    @Override
    public List<Book> findByAfterReleaseYear(int releaseYear) {
        return books.stream()
                .filter(book -> book.getReleaseYear() > releaseYear)
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> searchByPhrase(String phrase) {
        String lowerCasePhrase = phrase.toLowerCase();
        return books.stream()
                .filter(book -> Stream.of(book)
                            .map(b -> b.getTitle())
                            .flatMap(title -> Stream.of(title.split(" ")))
                            .map(word -> word.toLowerCase())
                            .anyMatch(word -> lowerCasePhrase.contains(word)))
                .collect(Collectors.toList());
    }

}
