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
        MyLinkedListItem tmpItem = head;
        for (int i = 0; i < index; i++) {
            tmpItem = tmpItem.nextItem;
        }
        return tmpItem.value;
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
