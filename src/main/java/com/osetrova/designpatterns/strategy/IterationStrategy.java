package com.osetrova.designpatterns.strategy;

import com.osetrova.designpatterns.model.tree.BinaryTree;

import java.util.Deque;

public interface IterationStrategy {

    <T extends Comparable<T>> BinaryTree.Node<T> next(Deque<BinaryTree.Node<T>> nodes);
}
