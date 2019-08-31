package pl.sdacademy.javapoz19programowanie1.recursive;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FibonacciTest {

    @Test
    public void iteration() {
        Fibonacci fibonacci = new Fibonacci();

        Assert.assertEquals(0, fibonacci.iteration(0));
        Assert.assertEquals(1, fibonacci.iteration(1));
        Assert.assertEquals(1, fibonacci.iteration(2));
        Assert.assertEquals(2, fibonacci.iteration(3));
        Assert.assertEquals(3, fibonacci.iteration(4));
        Assert.assertEquals(5, fibonacci.iteration(5));
        Assert.assertEquals(8, fibonacci.iteration(6));
    }

    @Test
    public void recursive() {
        Fibonacci fibonacci = new Fibonacci();

        Assert.assertEquals(0, fibonacci.recursive(0));
        Assert.assertEquals(1, fibonacci.recursive(1));
        Assert.assertEquals(1, fibonacci.recursive(2));
        Assert.assertEquals(2, fibonacci.recursive(3));
        Assert.assertEquals(3, fibonacci.recursive(4));
        Assert.assertEquals(5, fibonacci.recursive(5));
        Assert.assertEquals(8, fibonacci.recursive(6));
    }
}