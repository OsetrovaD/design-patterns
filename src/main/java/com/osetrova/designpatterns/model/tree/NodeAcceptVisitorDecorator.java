package com.osetrova.designpatterns.model.tree;

import com.osetrova.designpatterns.model.visitor.BinaryTreeVisitor;

public class NodeAcceptVisitorDecorator<T extends Comparable<T>> implements AcceptVisitor<T> {

    private Node<T> node;

    public NodeAcceptVisitorDecorator(Node<T> node) {
        this.node = node;
    }

    @Override
    public void accept(BinaryTreeVisitor<T> visitor){
        visitor.collectStatistic(this);
    }

    @Override
    public T getKey() {
        return node.getKey();
    }
}
