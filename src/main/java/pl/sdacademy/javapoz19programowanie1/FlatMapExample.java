package pl.sdacademy.javapoz19programowanie1;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class FlatMapExample {
    public static void main(String[] args) {
        List<String> maleNames = Arrays.asList("Pawel", "Piotr", "Tomasz");
        List<String> femaleNames = Arrays.asList("Patrycja", "Anna", "Karolina");

        for (int i = 0; i < 10; i++) {

            Stream.of(maleNames, femaleNames)
                    .flatMap(e -> e.stream())
                    .filter(name -> name.toLowerCase().startsWith("p"))
                    .sorted((a, b) -> new Random().nextInt(2) - 1)
                    .findAny()
                    .ifPresent(name -> System.out.println(name));
        }
    }
}
