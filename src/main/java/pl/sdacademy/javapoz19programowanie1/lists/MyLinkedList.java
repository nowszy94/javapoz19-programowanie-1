package pl.sdacademy.javapoz19programowanie1.lists;

public class MyLinkedList {

    private MyLinkedListItem head;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void add(Integer value) {
        MyLinkedListItem myLinkedListItem = new MyLinkedListItem(value);

        if (this.head == null) {
            this.head = myLinkedListItem;
        } else {
            MyLinkedListItem lastItem = getLastItem();
            lastItem.nextItem = myLinkedListItem;
        }

        size++;
    }

    // TODO - obsluga pustej listy
    // TODO - obluga blednego indexu (ArrayIndexOutOfBoundException)
    public Integer get(int index) {
        return getElement(index).value;
    }

    private MyLinkedListItem getElement(int index) {
        MyLinkedListItem tmpItem = head;
        for (int i = 0; i < index; i++) {
            tmpItem = tmpItem.nextItem;
        }
        return tmpItem;
    }

    public void remove(int index) {
        // bedzie trzeba uzyc metody getElement

        // 1. pobieramy poprzednik elementu index
        MyLinkedListItem previous = getElement(index - 1);

        // 2. pobieramy element do usunieca
        MyLinkedListItem toRemove = getElement(index);

        // 3. zmieniamy nextValue w poprzedniku na nextValue elementu ktory usuwamy
        previous.nextItem = toRemove.nextItem;
//        previous.nextItem = previous.nextItem.nextItem;

        // 4. w usuwanym elemencie null'ujemy nextValue
        toRemove.nextItem = null;

        size--;
    }

    // TODO - na 31.08 zadanie domowe
    public void add(int index, Integer value) {

    }

    public int size() {
        return size;
    }

    private MyLinkedListItem getLastItem() {
        MyLinkedListItem tmpItem = this.head;
        while (tmpItem.nextItem != null) {
            tmpItem = tmpItem.nextItem;
        }
        return tmpItem;
    }

    static class MyLinkedListItem {
        private Integer value;
        private MyLinkedListItem nextItem;

        private MyLinkedListItem(Integer value) {
            this.value = value;
        }
    }
}
