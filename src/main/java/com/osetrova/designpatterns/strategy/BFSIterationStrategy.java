package com.osetrova.designpatterns.strategy;

import com.osetrova.designpatterns.model.tree.BinaryTree;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Deque;

import static java.util.Objects.nonNull;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class BFSIterationStrategy implements IterationStrategy {

    private static volatile BFSIterationStrategy instance;

    public static BFSIterationStrategy getInstance() {
        if (instance == null) {
            synchronized (BFSIterationStrategy.class) {
                if (instance == null) {
                    instance = new BFSIterationStrategy();
                }
            }
        }

        return instance;
    }

    @Override
    public <T extends Comparable<T>> BinaryTree.Node<T> next(Deque<BinaryTree.Node<T>> nodes) {
        BinaryTree.Node<T> currentNode = nodes.remove();

        if (nonNull(currentNode.getLeftChild())) {
            nodes.add(currentNode.getLeftChild());
        }

        if (nonNull(currentNode.getRightChild())) {
            nodes.add(currentNode.getRightChild());
        }

        return currentNode;
    }
}
