package pl.sdacademy.javapoz19programowanie1.algorithms;

import java.util.Arrays;

public class Sort {

    public Integer[] bubbleSort(Integer[] values) {
        for (int i = 0; i < values.length; i++) {
            for (int j = 1; j < values.length - i; j++) {
                if (values[j - 1] > values[j]) {
                    swap(values, j-1, j);
                }
            }
        }
        return values;
    }

    public Integer[] insertionSort(Integer[] values) {
        for (int i = 0; i < values.length; i++) {
            int j = i;
            int nextValue = values[i];
            while (j > 0 && values[j-1] > nextValue) {
                values[j] = values[j-1];
                j--;
            }
            values[j] = nextValue;
        }
        return values;
    }

    public Integer[] selectionSort(Integer[] values) {
        for (int i = 0; i < values.length; i++) {
            swap(values, indexOfMin(Arrays.copyOfRange(values, i, values.length)) + i, i);
        }
        return values;
    }

    public Integer[] countingSort(Integer[] values) {
        int min = min(values);
        int max = max(values);

        int[] countingArray = new int[max-min + 1];

        for (int i = 0; i < values.length; i++) {
            countingArray[values[i] - min]++;
        }

        int nextIndex = 0;
        for (int i = 0; i < countingArray.length; i++) {
            for (int j = 0; j < countingArray[i]; j++) {
                values[nextIndex++] = min + i;
            }
        }
        return values;
    }

    public Integer min(Integer[] values) {
        return values[indexOfMin(values)];
    }

    public Integer max(Integer[] values) {
        int max = values[0];
        for (int i = 1; i < values.length; i++) {
            if (values[i] > max) {
                max = values[i];
            }
        }
        return max;
    }

    private Integer indexOfMin(Integer[] values) {
        int indexOfMin = 0;
        for (int i = 1; i < values.length; i++) {
            if (values[i] < values[indexOfMin]) {
                indexOfMin = i;
            }
        }
        return indexOfMin;
    }

    private void swap(Integer[] values, int i, int j) {
        int tmp = values[i];
        values[i] = values[j];
        values[j] = tmp;
    }
}
