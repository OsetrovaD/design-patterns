package com.osetrova.designpatterns.model.tree;

import com.osetrova.designpatterns.model.visitor.BinaryTreeVisitor;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NodeAcceptVisitorDecorator<T extends Comparable<T>> implements AcceptVisitorNode<T> {

    private BinaryTreeNode<T> node;

    @Override
    public void accept(BinaryTreeVisitor<T> visitor){
        visitor.collectStatistic(this);
    }

    @Override
    public T getKey() {
        return node.getKey();
    }
}
