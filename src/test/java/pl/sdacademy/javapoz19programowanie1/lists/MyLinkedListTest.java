package pl.sdacademy.javapoz19programowanie1.lists;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

public class MyLinkedListTest {

    @Test
    public void addShouldAddElementToEmptyList() {
        // given
        MyLinkedList myLinkedList = new MyLinkedList();

        // when
        myLinkedList.add(5);

        // then
        Assert.assertEquals(1, myLinkedList.size());
    }

    @Test
    public void shouldAddElementToNonEmptyList() {
        // given
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);

        // when
        myLinkedList.add(5);

        // then
        Assert.assertEquals(5, myLinkedList.size());
    }

    @Test
    public void getShouldReturnFirstElement() {
        // TODO - dopisac testy
    }

    @Test
    public void getShouldReturnLastElement() {
        // TODO - dopisac testy
    }

    @Test
    public void getShouldReturnMiddleElement() {
        // given
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(0);
        myLinkedList.add(10);
        myLinkedList.add(20);
        myLinkedList.add(30);
        myLinkedList.add(40);
        myLinkedList.add(50);

        // when
        Integer result = myLinkedList.get(3);

        // then
        Assert.assertEquals((Integer) 30, result);

    }

    @Test
    public void removeShouldRemoveMiddleElement() {
        // given
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(0);
        myLinkedList.add(10);
        myLinkedList.add(20);
        myLinkedList.add(30);
        myLinkedList.add(40);

        // when
        myLinkedList.remove(2);

        // then
        Assert.assertEquals(4, myLinkedList.size());
        Assert.assertEquals((Integer) 0, myLinkedList.get(0));
        Assert.assertEquals((Integer) 10, myLinkedList.get(1));
        Assert.assertEquals((Integer) 30, myLinkedList.get(2));
        Assert.assertEquals((Integer) 40, myLinkedList.get(3));
    }

    @Test
    public void addShouldAddNewItemAtIndex() {
        // given
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(0);
        myLinkedList.add(10);
        myLinkedList.add(30);
        myLinkedList.add(40);

        // when
        myLinkedList.add(2, 20);

        // then
        Assert.assertEquals(5, myLinkedList.size());
        Assert.assertEquals((Integer) 0, myLinkedList.get(0));
        Assert.assertEquals((Integer) 10, myLinkedList.get(1));
        Assert.assertEquals((Integer) 20, myLinkedList.get(2));
        Assert.assertEquals((Integer) 30, myLinkedList.get(3));
        Assert.assertEquals((Integer) 40, myLinkedList.get(4));
    }
}