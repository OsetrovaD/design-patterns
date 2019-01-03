package com.osetrova.designpatterns.model.visitor;

import com.osetrova.designpatterns.model.tree.AcceptVisitorNode;

public interface BinaryTreeVisitor<T extends Comparable<T>> {

    void collectStatistic(AcceptVisitorNode<T> node);
}
