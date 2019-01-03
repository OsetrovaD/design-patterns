package com.osetrova.designpatterns.iterator;

import com.osetrova.designpatterns.model.tree.BinaryTree;
import com.osetrova.designpatterns.strategy.IterationStrategy;
import lombok.Setter;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class BinaryTreeIterator<T extends Comparable<T>> implements Iterator<BinaryTree.Node<T>> {

    @Setter
    private IterationStrategy strategy;
    private Deque<BinaryTree.Node<T>> nodes = new ArrayDeque<>();

    public BinaryTreeIterator(BinaryTree<T> currentTree, IterationStrategy strategy) {
        this.nodes.add(currentTree.getRoot());
        this.strategy = strategy;
    }

    @Override
    public boolean hasNext() {
        return !nodes.isEmpty();
    }

    @Override
    public BinaryTree.Node<T> next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        return strategy.next(nodes);
    }
}
