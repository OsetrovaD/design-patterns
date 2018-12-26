package com.osetrova.designpatterns.strategy;

import com.osetrova.designpatterns.model.BinaryTree;

import java.util.Deque;

public interface IterationStrategy {

    <T extends Comparable<T>> T getCurrentValue(Deque<BinaryTree.Node<T>> nodes);
}
