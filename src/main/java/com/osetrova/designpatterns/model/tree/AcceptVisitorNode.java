package com.osetrova.designpatterns.model.tree;

import com.osetrova.designpatterns.model.visitor.BinaryTreeVisitor;

public interface AcceptVisitorNode<T extends Comparable<T>> extends BinaryTreeNode<T> {

    void accept(BinaryTreeVisitor<T> visitor);
}
