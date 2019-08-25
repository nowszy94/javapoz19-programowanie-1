package pl.sdacademy.javapoz19programowanie1.lists;

import org.junit.Assert;
import org.junit.Test;

public class SearchTest {

    @Test
    public void binarySearch_ShouldFindNumberInTableOfOddLength() {
        // given
        Search search = new Search();

        int[] numbers = {0, 1, 3, 5, 6, 8, 9};

        // when
        int result = search.binarySearch(6, numbers);

        // then
        Assert.assertEquals(4, result);
    }

    @Test
    public void binarySearch_ShouldNotFindNumberInTableOfOddLength() {
        // given
        Search search = new Search();

        int[] numbers = {0, 1, 3, 5, 6, 8, 9};

        // when
        int result = search.binarySearch(7, numbers);

        // then
        Assert.assertEquals(-1, result);
    }

    @Test
    public void binarySearch_ShouldFindCenterNumberInTableOfOddLength() {
        // given
        Search search = new Search();

        int[] numbers = {0, 1, 3, 5, 6, 8, 9};

        // when
        int result = search.binarySearch(5, numbers);

        // then
        Assert.assertEquals(3, result);
    }

    @Test
    public void binarySearch_ShouldFindNumberInTableOfEvenLength() {
        // given
        Search search = new Search();

        int[] numbers = {0, 1, 3, 5, 6, 8, 9, 10};

        // when
        int result = search.binarySearch(6, numbers);

        // then
        Assert.assertEquals(4, result);
    }

    @Test
    public void binarySearch_ShouldNotFindNumberInTableOfEvenLength() {
        // given
        Search search = new Search();

        int[] numbers = {0, 1, 3, 5, 6, 8, 9, 10};

        // when
        int result = search.binarySearch(7, numbers);

        // then
        Assert.assertEquals(-1, result);
    }

    @Test
    public void binarySearch_ShouldFindCenterNumberInTableOfEvenLength() {
        // given
        Search search = new Search();

        int[] numbers = {0, 1, 3, 5, 6, 8, 9, 10};

        // when
        int result = search.binarySearch(5, numbers);

        // then
        Assert.assertEquals(3, result);
    }

    @Test
    public void a() {
        // given
        Search search = new Search();

        int[] numbers = {1, 3, 4, 5, 7, 8, 9, 11, 13};

        // when
        int result = search.binarySearch(10, numbers);

        // then
        Assert.assertEquals(-1, result);
    }
}