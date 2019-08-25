package pl.sdacademy.javapoz19programowanie1.lists;

import org.junit.Assert;
import org.junit.Test;

public class MyArrayListTest {

    @Test
    public void removeOfMiddleElementShouldRemoveItFromList() {
        // given
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(3);
        myArrayList.add(5);

        // when
        myArrayList.remove(1);

        // then
        Assert.assertEquals(2, myArrayList.size());

        Assert.assertEquals((Integer) 1, myArrayList.get(0));
        Assert.assertEquals((Integer) 5, myArrayList.get(1));
    }

    @Test
    public void removeOfLastElementShouldRemoveItFromList() {
        // given
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(3);
        myArrayList.add(5);

        // when
        myArrayList.remove(2);

        // then
        Assert.assertEquals(2, myArrayList.size());

        Assert.assertEquals((Integer) 1, myArrayList.get(0));
        Assert.assertEquals((Integer) 3, myArrayList.get(1));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void removeOfNonExistingElementShouldThrowArrayIndexOutOfBoundException() {
        // given
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(3);
        myArrayList.add(5);

        //when
        myArrayList.remove(3);
    }

    @Test
    public void add_replacingShouldAddElementInMiddleOfList() {
        // given
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(0);
        myArrayList.add(10);
        myArrayList.add(20);
        myArrayList.add(40);
        myArrayList.add(50);

        // when
        myArrayList.add_replacing(3, 30);

        // then
        Assert.assertEquals(6, myArrayList.size());
        Assert.assertEquals((Integer) 0, myArrayList.get(0));
        Assert.assertEquals((Integer) 10, myArrayList.get(1));
        Assert.assertEquals((Integer) 20, myArrayList.get(2));
        Assert.assertEquals((Integer) 30, myArrayList.get(3));
        Assert.assertEquals((Integer) 40, myArrayList.get(4));
        Assert.assertEquals((Integer) 50, myArrayList.get(5));
    }

    @Test
    public void add_replacingShouldAddElementInMiddleOfListOfSize10() {
        // given
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(0);
        myArrayList.add(10);
        myArrayList.add(20);
//        myArrayList.add(30);
        myArrayList.add(40);
        myArrayList.add(50);
        myArrayList.add(60);
        myArrayList.add(70);
        myArrayList.add(80);
        myArrayList.add(90);
        myArrayList.add(100);

        // when
        myArrayList.add_replacing(3, 30);

        // then
        Assert.assertEquals(11, myArrayList.size());
        Assert.assertEquals((Integer) 0, myArrayList.get(0));
        Assert.assertEquals((Integer) 10, myArrayList.get(1));
        Assert.assertEquals((Integer) 20, myArrayList.get(2));
        Assert.assertEquals((Integer) 30, myArrayList.get(3));
        Assert.assertEquals((Integer) 40, myArrayList.get(4));
        Assert.assertEquals((Integer) 50, myArrayList.get(5));
        Assert.assertEquals((Integer) 60, myArrayList.get(6));
        Assert.assertEquals((Integer) 70, myArrayList.get(7));
        Assert.assertEquals((Integer) 80, myArrayList.get(8));
        Assert.assertEquals((Integer) 90, myArrayList.get(9));
        Assert.assertEquals((Integer) 100, myArrayList.get(10));
    }

    @Test
    public void add_replacingShouldAddElementAtEnd() {
        // given
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(0);
        myArrayList.add(10);
        myArrayList.add(20);
        myArrayList.add(30);
        myArrayList.add(40);

        // when
        myArrayList.add_replacing(5, 50);

        // then
        Assert.assertEquals(6, myArrayList.size());
        Assert.assertEquals((Integer) 0, myArrayList.get(0));
        Assert.assertEquals((Integer) 10, myArrayList.get(1));
        Assert.assertEquals((Integer) 20, myArrayList.get(2));
        Assert.assertEquals((Integer) 30, myArrayList.get(3));
        Assert.assertEquals((Integer) 40, myArrayList.get(4));
        Assert.assertEquals((Integer) 50, myArrayList.get(5));
    }

    @Test
    public void add_replacingShouldAddElementAtBeginning() {
        // given
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(10);
        myArrayList.add(20);
        myArrayList.add(30);
        myArrayList.add(40);
        myArrayList.add(50);

        // when
        myArrayList.add_replacing(0, 0);

        // then
        Assert.assertEquals(6, myArrayList.size());
        Assert.assertEquals((Integer) 0, myArrayList.get(0));
        Assert.assertEquals((Integer) 10, myArrayList.get(1));
        Assert.assertEquals((Integer) 20, myArrayList.get(2));
        Assert.assertEquals((Integer) 30, myArrayList.get(3));
        Assert.assertEquals((Integer) 40, myArrayList.get(4));
        Assert.assertEquals((Integer) 50, myArrayList.get(5));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void add_replacingShouldThrowArrayIndexOutOfBoundsExceptionWhenAddingOnWrongIndex() {
        // given
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(0);
        myArrayList.add(10);
        myArrayList.add(20);
        myArrayList.add(30);
        myArrayList.add(40);
        myArrayList.add(50);

        // when
        myArrayList.add_replacing(7, 70);
    }

    @Test
    public void add_cloneArrayShouldAddElementInMiddleOfList() {
        // given
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(0);
        myArrayList.add(10);
        myArrayList.add(20);
        myArrayList.add(40);
        myArrayList.add(50);

        // when
        myArrayList.add_cloneArray(3, 30);

        // then
        Assert.assertEquals(6, myArrayList.size());
        Assert.assertEquals((Integer) 0, myArrayList.get(0));
        Assert.assertEquals((Integer) 10, myArrayList.get(1));
        Assert.assertEquals((Integer) 20, myArrayList.get(2));
        Assert.assertEquals((Integer) 30, myArrayList.get(3));
        Assert.assertEquals((Integer) 40, myArrayList.get(4));
        Assert.assertEquals((Integer) 50, myArrayList.get(5));
    }

    @Test
    public void add_cloneArrayShouldAddElementInMiddleOfListOfSize10() {
        // given
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(0);
        myArrayList.add(10);
        myArrayList.add(20);
//        myArrayList.add(30);
        myArrayList.add(40);
        myArrayList.add(50);
        myArrayList.add(60);
        myArrayList.add(70);
        myArrayList.add(80);
        myArrayList.add(90);
        myArrayList.add(100);

        // when
        myArrayList.add_cloneArray(3, 30);

        // then
        Assert.assertEquals(11, myArrayList.size());
        Assert.assertEquals((Integer) 0, myArrayList.get(0));
        Assert.assertEquals((Integer) 10, myArrayList.get(1));
        Assert.assertEquals((Integer) 20, myArrayList.get(2));
        Assert.assertEquals((Integer) 30, myArrayList.get(3));
        Assert.assertEquals((Integer) 40, myArrayList.get(4));
        Assert.assertEquals((Integer) 50, myArrayList.get(5));
        Assert.assertEquals((Integer) 60, myArrayList.get(6));
        Assert.assertEquals((Integer) 70, myArrayList.get(7));
        Assert.assertEquals((Integer) 80, myArrayList.get(8));
        Assert.assertEquals((Integer) 90, myArrayList.get(9));
        Assert.assertEquals((Integer) 100, myArrayList.get(10));
    }

    @Test
    public void add_cloneArrayShouldAddElementAtEnd() {
        // given
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(0);
        myArrayList.add(10);
        myArrayList.add(20);
        myArrayList.add(30);
        myArrayList.add(40);

        // when
        myArrayList.add_cloneArray(5, 50);

        // then
        Assert.assertEquals(6, myArrayList.size());
        Assert.assertEquals((Integer) 0, myArrayList.get(0));
        Assert.assertEquals((Integer) 10, myArrayList.get(1));
        Assert.assertEquals((Integer) 20, myArrayList.get(2));
        Assert.assertEquals((Integer) 30, myArrayList.get(3));
        Assert.assertEquals((Integer) 40, myArrayList.get(4));
        Assert.assertEquals((Integer) 50, myArrayList.get(5));
    }

    @Test
    public void add_cloneArrayShouldAddElementAtBeginning() {
        // given
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(10);
        myArrayList.add(20);
        myArrayList.add(30);
        myArrayList.add(40);
        myArrayList.add(50);

        // when
        myArrayList.add_cloneArray(0, 0);

        // then
        Assert.assertEquals(6, myArrayList.size());
        Assert.assertEquals((Integer) 0, myArrayList.get(0));
        Assert.assertEquals((Integer) 10, myArrayList.get(1));
        Assert.assertEquals((Integer) 20, myArrayList.get(2));
        Assert.assertEquals((Integer) 30, myArrayList.get(3));
        Assert.assertEquals((Integer) 40, myArrayList.get(4));
        Assert.assertEquals((Integer) 50, myArrayList.get(5));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void add_cloneArrayShouldThrowArrayIndexOutOfBoundsExceptionWhenAddingOnWrongIndex() {
        // given
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(0);
        myArrayList.add(10);
        myArrayList.add(20);
        myArrayList.add(30);
        myArrayList.add(40);
        myArrayList.add(50);

        // when
        myArrayList.add_cloneArray(7, 70);
    }
}