package com.pipi.improve.treeDemo;

/**
 * Created by pipi on 2017/4/16.
 */
public class MainTest {
    public static void main(String [] args){
        Mytree tree = new Mytree("A");

        tree.setLeftChild(new Mytree("B"));
        tree.setRightChild(new Mytree("C"));

        tree.getLeftChild().setLeftChild(new Mytree("D"));
        tree.getLeftChild().setRightChild(new Mytree("E"));

        tree.getLeftChild().getRightChild().setLeftChild(new Mytree("G"));

        tree.getRightChild().setRightChild(new Mytree("F"));

        TreeManager.viewTreeFirst(tree);

        TreeManager.viewTreeMiddle(tree);

        TreeManager.viewTreeBehind(tree);
    }
}
