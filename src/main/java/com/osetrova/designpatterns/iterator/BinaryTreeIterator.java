package com.osetrova.designpatterns.iterator;

import com.osetrova.designpatterns.model.BinaryTree;
import com.osetrova.designpatterns.strategy.IterationStrategy;
import lombok.Setter;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class BinaryTreeIterator<T extends Comparable<T>> implements Iterator<T> {

    @Setter
    private IterationStrategy strategy;
    private BinaryTree<T> currentTree;
    private Deque<BinaryTree.Node<T>> nodes = new ArrayDeque<>();
    private boolean isIterationJustStarted = true;

    public BinaryTreeIterator(BinaryTree<T> currentTree, IterationStrategy strategy) {
        this.currentTree = currentTree;
        this.strategy = strategy;
    }

    @Override
    public boolean hasNext() {
        boolean result;
        if (isIterationJustStarted) {
            result = currentTree.getRoot() != null;
        } else {
            result = !nodes.isEmpty();

            if (!result) {
                isIterationJustStarted = true;
            }
        }

        return result;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        if (isIterationJustStarted) {
            nodes.add(currentTree.getRoot());
            isIterationJustStarted = false;
        }

        return strategy.getCurrentValue(nodes);
    }
}
