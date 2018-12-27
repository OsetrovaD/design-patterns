package com.osetrova.designpatterns.strategy;

import com.osetrova.designpatterns.model.tree.BinaryTree;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Deque;

import static java.util.Objects.nonNull;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DFSPreOrderIterationStrategy implements IterationStrategy {

    private static volatile DFSPreOrderIterationStrategy instance;

    public static DFSPreOrderIterationStrategy getInstance() {
        if (instance == null) {
            synchronized (DFSPreOrderIterationStrategy.class) {
                if (instance == null) {
                    instance = new DFSPreOrderIterationStrategy();
                }
            }
        }

        return instance;
    }

    @Override
    public <T extends Comparable<T>> BinaryTree.Node<T> getCurrentValue(Deque<BinaryTree.Node<T>> nodes) {
        BinaryTree.Node<T> currentNode = nodes.pop();

        if (nonNull(currentNode.getRightChild())) {
            nodes.push(currentNode.getRightChild());
        }

        if (nonNull(currentNode.getLeftChild())) {
            nodes.push(currentNode.getLeftChild());
        }

        return currentNode;
    }
}
