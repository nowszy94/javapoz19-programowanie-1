package pl.sdacademy.javapoz19programowanie1.recursive;

public class Factorial {
    public long iteration(int value) {
        long accumulator = 1;
        for (int i = 1; i <= value; i++) {
            // i++ -> i += 1 -> i = i + 1
            // accumulator = accumulator * i;
            accumulator *= i;
        }
        return accumulator;
    }

    public long recursive(int value) {
        if (value == 0) return 1;

        return value * recursive(value - 1);
    }
}
