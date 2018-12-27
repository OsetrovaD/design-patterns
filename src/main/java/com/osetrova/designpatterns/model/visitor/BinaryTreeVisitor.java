package com.osetrova.designpatterns.model.visitor;

import com.osetrova.designpatterns.model.tree.AcceptVisitor;

public interface BinaryTreeVisitor<T extends Comparable<T>> {

    void collectStatistic(AcceptVisitor<T> node);
}
