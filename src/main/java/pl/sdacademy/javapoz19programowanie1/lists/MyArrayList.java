package pl.sdacademy.javapoz19programowanie1.lists;

public class MyArrayList {

    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();

        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(4);
    }

    private Integer[] data;
    private int size;

    public MyArrayList() {
        this.data = new Integer[10];
        this.size = 0;
    }

    public Integer get(int index) {
        if (index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return data[index];
    }

    public void add(Integer value) {
        doubleSpaceIfNeeded();
        data[size++] = value;
    }

    public void add_replacing(int index, Integer value) {
        if (index > size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }

        doubleSpaceIfNeeded();
//        for (int i = size - 1; i >= index; i--) {
//            data[i + 1] = data[i];
//        }
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }

        data[index] = value;
        size++;
    }

    public void add_cloneArray(int index, Integer value) {
        if (index > size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }

        Integer[] newArray = new Integer[data.length + 1];
        // 1. przepisujemy lewa czesc
        for (int i = 0; i < index; i++) {
            newArray[i] = data[i];
        }
        // 2. wstawiamy wartosc
        newArray[index] = value;

        // 3. przepisujemy prawa czesc
        for (int i = index + 1; i < size + 1; i++) {
            newArray[i] = data[i - 1];
        }

        this.data = newArray;
        size++;
    }

    public void remove(int index) {
        if (index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }

        if (index == size - 1) {
            size--;
            return;
        }

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i+1];
        }
        size--;
    }

    public int size() {
        return size;
    }

    private void doubleSpaceIfNeeded() {
        if (size == data.length) {
            Integer[] newArray = new Integer[data.length * 2];
            for (int i = 0; i < data.length; i++) {
                newArray[i] = data[i];
            }
            this.data = newArray;

//            this.data = Arrays.copyOf(data, data.length * 2);
        }
    }
}
