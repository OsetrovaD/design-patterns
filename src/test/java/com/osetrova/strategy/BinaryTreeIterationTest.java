package com.osetrova.strategy;

import com.osetrova.designpatterns.iterator.BinaryTreeIterator;
import com.osetrova.designpatterns.strategy.BFSIterationStrategy;
import com.osetrova.designpatterns.strategy.DFSPreOrderIterationStrategy;
import com.osetrova.util.TestTreeInitUtil;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BinaryTreeIterationTest {

    @Test
    public void checkBFSIteration() {
        BinaryTreeIterator<Integer> iterator = new BinaryTreeIterator<>(TestTreeInitUtil.buildIntegerTree(), BFSIterationStrategy.getInstance());
        List<Integer> actual = new ArrayList<>();

        while (iterator.hasNext()) {
            actual.add(iterator.next().getKey());
        }

        List<Integer> expectedValues = new ArrayList<>();
        expectedValues.add(8);
        expectedValues.add(3);
        expectedValues.add(10);
        expectedValues.add(1);
        expectedValues.add(6);
        expectedValues.add(14);
        expectedValues.add(4);
        expectedValues.add(7);
        expectedValues.add(13);

        assertEquals(expectedValues, actual);
    }

    @Test
    public void checkDFSPreOrderIteration() {
        BinaryTreeIterator<Integer> iterator = new BinaryTreeIterator<>(TestTreeInitUtil.buildIntegerTree(), DFSPreOrderIterationStrategy.getInstance());
        List<Integer> actual = new ArrayList<>();

        while (iterator.hasNext()) {
            actual.add(iterator.next().getKey());
        }

        List<Integer> expectedValues = new ArrayList<>();
        expectedValues.add(8);
        expectedValues.add(3);
        expectedValues.add(1);
        expectedValues.add(6);
        expectedValues.add(4);
        expectedValues.add(7);
        expectedValues.add(10);
        expectedValues.add(14);
        expectedValues.add(13);

        assertEquals(expectedValues, actual);
    }
}
