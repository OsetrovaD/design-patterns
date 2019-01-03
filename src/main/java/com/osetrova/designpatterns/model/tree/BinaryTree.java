package com.osetrova.designpatterns.model.tree;

import lombok.Getter;

@Getter
public class BinaryTree <T extends Comparable<T>> {

    private Node<T> root;

    public void add(T key) {
        Node<T> newNode = new Node<>(key);

        if (root == null) {
            root = newNode;
        } else {
            Node<T> current = root;
            Node<T> parent;

            while (true) {
                parent = current;
                if (current.key.compareTo(key) > 0) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newNode;
                        break;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        break;
                    }
                }
            }
        }
    }

    @Getter
    public static class Node<Y extends Comparable<Y>> implements BinaryTreeNode {
        private Y key;
        private Node<Y> leftChild;
        private Node<Y> rightChild;

        private Node(Y key) {
            this.key = key;
        }
    }
}
