package pl.sdacademy.javapoz19programowanie1.lists;

public class Search {
    public static void main(String[] args) {
        Search search = new Search();

        System.out.println(search.binarySearch(6, new int[]{0, 1, 3, 5, 6, 8, 9}));
        System.out.println(search.binarySearch(7, new int[]{0, 1, 3, 5, 6, 8, 9}));
        System.out.println(search.binarySearch(5, new int[]{0, 1, 3, 5, 6, 8, 9}));

        System.out.println(search.binarySearch(5, new int[]{1, 2, 3, 6, 7, 9, 10, 11, 15, 16, 19, 30, 31, 32, 45}));
    }

    public int binarySearch(int value, int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int center = (left + right) / 2;
            int midValue = numbers[center];

            if (midValue < value) {
                left = center + 1;
            } else if (midValue > value) {
                right = center - 1;
            } else {
                left = right = center;
            }
        }

        return value == numbers[left] ? left : -1;
    }
}

