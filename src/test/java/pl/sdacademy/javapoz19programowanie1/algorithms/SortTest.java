package pl.sdacademy.javapoz19programowanie1.algorithms;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortTest {

    private Sort sort;
    private List<String> failureMessages;

    @Before
    public void init() {
        sort = new Sort();
        failureMessages = new ArrayList<>();
    }

    @Test
    public void bubbleSort() {
        testSort("bubble-sort", sort::bubbleSort);
    }

    @Test
    public void insertionSort() {
        testSort("insertion-sort", sort::insertionSort);
    }

    @Test
    public void selectionSort() {
        testSort("sellection-sort", sort::selectionSort);
    }

    @Test
    public void countingSort() {
        testSort("counting-sort", sort::countingSort);
    }

    @Test
    public void min() {
        Assert.assertEquals(new Integer(0), sort.min(new Integer[]{0, 1, 2, 3, 4, 5, 6}));
        Assert.assertEquals(new Integer(0), sort.min(new Integer[]{6, 5, 4, 3, 2, 1, 0}));
        Assert.assertEquals(new Integer(0), sort.min(new Integer[]{0}));
        Assert.assertEquals(new Integer(0), sort.min(new Integer[]{3, 2, 6, 1, 0, 6, 4, 2, 1, 3, 5, 6}));
    }

    @Test
    public void max() {
        Assert.assertEquals(new Integer(6), sort.max(new Integer[]{0, 1, 2, 3, 4, 5, 6}));
        Assert.assertEquals(new Integer(6), sort.max(new Integer[]{6, 5, 4, 3, 2, 1, 0}));
        Assert.assertEquals(new Integer(0), sort.max(new Integer[]{0}));
        Assert.assertEquals(new Integer(7), sort.max(new Integer[]{3, 2, 6, 1, 0, 7, 4, 2, 1, 3, 7, 5, 6}));
    }

    private void testSort(String sortName, Function<Integer[], Integer[]> sortFunction) {
        sortAndValidateArrayOfOneElement(sortName, sortFunction);
        sortAndValidateArrayOfEvenLength(sortName, sortFunction);
        sortAndValidateArrayOfOddLength(sortName, sortFunction);
        sortAndValidateAscSortedArrayOfEvenLength(sortName, sortFunction);
        sortAndValidateAscSortedArrayOfOddLength(sortName, sortFunction);
        sortAndValidateDescSortedArrayOfEvenLength(sortName, sortFunction);
        sortAndValidateDescSortedArrayOfOddLength(sortName, sortFunction);

        if (!failureMessages.isEmpty()) {
            Assert.fail(failureMessages.stream().collect(Collectors.joining("\n")));
        }
    }

    private void sortAndValidateArrayOfOneElement(String sortName, Function<Integer[], Integer[]> sortFunction) {
        Integer[] values = {3};

        sortAndAssert(sortName, "sortAndValidateArrayOfOneElement", sortFunction.apply(values));
    }

    private void sortAndValidateArrayOfEvenLength(String sortName, Function<Integer[], Integer[]> sortFunction) {
        Integer[] values = {3, 7, 5, 2, 4, 1};

        sortAndAssert(sortName, "sortAndValidateArrayOfEvenLength", sortFunction.apply(values));
    }

    private void sortAndValidateArrayOfOddLength(String sortName, Function<Integer[], Integer[]> sortFunction) {
        Integer[] values = {3, 7, 5, 2, 4, 1, 6};

        sortAndAssert(sortName, "sortAndValidateArrayOfOddLength", sortFunction.apply(values));
    }

    private void sortAndValidateAscSortedArrayOfEvenLength(String sortName, Function<Integer[], Integer[]> sortFunction) {
        Integer[] values = {1, 2, 3, 4, 5, 6};

        sortAndAssert(sortName, "sortAndValidateAscSortedArrayOfEvenLength", sortFunction.apply(values));
    }

    private void sortAndValidateAscSortedArrayOfOddLength(String sortName, Function<Integer[], Integer[]> sortFunction) {
        Integer[] values = {1, 2, 3, 4, 5, 6, 7};

        sortAndAssert(sortName, "sortAndValidateAscSortedArrayOfOddLength", sortFunction.apply(values));
    }

    private void sortAndValidateDescSortedArrayOfEvenLength(String sortName, Function<Integer[], Integer[]> sortFunction) {
        Integer[] values = {6, 5, 4, 3, 2, 1};

        sortAndAssert(sortName, "sortAndValidateDescSortedArrayOfEvenLength", sortFunction.apply(values));
    }

    private void sortAndValidateDescSortedArrayOfOddLength(String sortName, Function<Integer[], Integer[]> sortFunction) {
        Integer[] values = {7, 6, 5, 4, 3, 2, 1};

        sortAndAssert(sortName, "sortAndValidateDescSortedArrayOfOddLength", sortFunction.apply(values));
    }

    private void sortAndAssert(String sortName, String caseName, Integer[] potentialySorted) {
        List<Integer> sorted = new ArrayList<>(Arrays.asList(potentialySorted));
        sorted.sort(Comparator.comparingInt(v -> v));

        if (!sorted.equals(new ArrayList<>(Arrays.asList(potentialySorted)))) {
            failureMessages.add(sortName + " does not work on case: " + caseName);
        }
    }
}
