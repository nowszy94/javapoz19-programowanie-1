package pl.sdacademy.javapoz19programowanie1.recursive;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class TreeTest {

    @Test
    public void addRecursive() {
        // given
        Tree tree = new Tree();

        // when
        tree.addRecursive(6, false);
        tree.addRecursive(4, false);
        tree.addRecursive(2, false);
        tree.addRecursive(5, false);
        tree.addRecursive(9, false);
        tree.addRecursive(7, false);
        tree.addRecursive(13, false);
        tree.addRecursive(12, false);
        tree.addRecursive(14, false);

        // then
        List<Integer> expected = new ArrayList<>(Arrays.asList(6, 4, 2, 5, 9, 7, 13, 12, 14));
        List<Integer> actual = tree.treeInOrder();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addRecursiveInOTherOrder() {
        // given
        Tree tree = new Tree();

        // when
        tree.addRecursive(6, false);
        tree.addRecursive(4, false);
        tree.addRecursive(9, false);
        tree.addRecursive(2, false);
        tree.addRecursive(5, false);
        tree.addRecursive(7, false);
        tree.addRecursive(13, false);
        tree.addRecursive(12, false);
        tree.addRecursive(14, false);

        // then
        List<Integer> expected = new ArrayList<>(Arrays.asList(6, 4, 2, 5, 9, 7, 13, 12, 14));
        List<Integer> actual = tree.treeInOrder();
        Assert.assertEquals(expected, actual);
    }
}