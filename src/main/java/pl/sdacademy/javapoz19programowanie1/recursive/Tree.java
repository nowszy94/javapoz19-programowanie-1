package pl.sdacademy.javapoz19programowanie1.recursive;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    private TreeItem root;

    public void addIteration(int value) {
        TreeItem cursor = root;
        TreeItem itemToAdd = new TreeItem(value);
        while (true) {
            if (value > cursor.value) {
                if (cursor.right != null) {
                    cursor = cursor.right;
                } else {
                    cursor.right = itemToAdd;
                    break;
                }
            } else {
                if (cursor.left != null) {
                    cursor = cursor.left;
                } else {
                    cursor.left = itemToAdd;
                    break;
                }
            }
        }
    }

    public void addRecursive(int value, boolean display) {
        if (root == null) {
            root = new TreeItem(value);
        } else {
            addItem(root, new TreeItem(value), display);
        }
    }

    public List<Integer> treeInOrder() {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        collectPreOrder(list, root);
        return list;
    }

    private void collectPreOrder(List<Integer> list, TreeItem item) {
        list.add(item.value);
        if (item.left != null) {
            collectPreOrder(list, item.left);
        }
        if (item.right != null) {
            collectPreOrder(list, item.right);
        }
    }

    private void addItem(TreeItem to, TreeItem itemToAdd, boolean display) {
        if (itemToAdd.value <= to.value) {
            if (display) System.out.println("on value " + to.value + " going left");
            addLeft(to, itemToAdd, display);
        } else {
            if (display) System.out.println("on value " + to.value + " going right");
            addRight(to, itemToAdd, display);
        }
    }

    private void addLeft(TreeItem to, TreeItem itemToAdd, boolean display) {
        if (to.left != null) {
            addItem(to.left, itemToAdd, display);
        } else {
            to.left = itemToAdd;
            if (display) System.out.println("adding value");
        }
    }

    private void addRight(TreeItem to, TreeItem itemToAdd, boolean display) {
        if (to.right != null) {
            addItem(to.right, itemToAdd, display);
        } else {
            to.right = itemToAdd;
            if (display) System.out.println("adding value");
        }
    }

    private static class TreeItem {
        private int value;
        private TreeItem left;
        private TreeItem right;

        public TreeItem(int value) {
            this.value = value;
        }
    }
}
