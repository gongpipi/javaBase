package com.pipi.improve.treeDemo;


import java.util.List;

/**
 * Created by pipi on 2017/4/16.
 */
public class TreeManager {

    public Mytree createTree(List<String> characterList, int index){
        Mytree mytree = new Mytree(characterList.get(index));
        return mytree;
    }

    public static void viewTreeFirst(Mytree mytree){
        if(mytree.getData() == null){
            System.out.println("先序遍历！");
            return;
        }
        System.out.print(mytree.getData() + " ");
        viewTreeFirst(mytree.getLeftChild());
        viewTreeFirst(mytree.getRightChild());
    }

    public static void viewTreeMiddle(Mytree mytree){
        if(mytree.getData() == null){
            System.out.println("中序遍历！");
            return;
        }
        viewTreeMiddle(mytree.getLeftChild());
        System.out.print(mytree.getData() + " ");
        viewTreeMiddle(mytree.getRightChild());
    }

    public static void viewTreeBehind(Mytree mytree){
        if(mytree.getData() == null){
            System.out.println("后序遍历！");
            return;
        }
        viewTreeBehind(mytree.getLeftChild());
        viewTreeBehind(mytree.getRightChild());
        System.out.print(mytree.getData() + " ");
    }

}
