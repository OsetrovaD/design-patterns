package com.osetrova.util;

import com.osetrova.designpatterns.model.BinaryTree;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TestTreeInitUtil {

    public static BinaryTree<Integer> buildIntegerTree() {
        BinaryTree<Integer> testTree = new BinaryTree<>();
        testTree.add(8);
        testTree.add(3);
        testTree.add(10);
        testTree.add(1);
        testTree.add(6);
        testTree.add(14);
        testTree.add(4);
        testTree.add(7);
        testTree.add(13);

        return testTree;
    }
}
