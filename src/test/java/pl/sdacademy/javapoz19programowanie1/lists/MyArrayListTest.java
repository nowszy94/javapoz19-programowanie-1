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
}