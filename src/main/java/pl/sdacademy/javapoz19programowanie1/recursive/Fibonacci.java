package pl.sdacademy.javapoz19programowanie1.recursive;

public class Fibonacci {
    public int iteration(int index) {
        int first = 0;
        int second = 1;

        if (index == 0) return first;
        if (index == 1) return second;

        for (int i = 2; i <= index; i++) {
            int nextValue = first + second;
            first = second;
            second = nextValue;
        }

        return second;
    }

    public int recursive(int index) {
        if (index == 0) return 0;
        if (index == 1) return 1;

        return recursive(index - 1) + recursive(index - 2);
    }
}
