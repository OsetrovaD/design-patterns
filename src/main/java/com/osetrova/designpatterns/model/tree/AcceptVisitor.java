package com.osetrova.designpatterns.model.tree;

import com.osetrova.designpatterns.model.visitor.BinaryTreeVisitor;

public interface AcceptVisitor<T extends Comparable<T>> extends Node<T> {

    void accept(BinaryTreeVisitor<T> visitor);
}
