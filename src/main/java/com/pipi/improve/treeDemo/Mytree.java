package com.pipi.improve.treeDemo;

/**
 * Created by pipi on 2017/4/16.
 */
public class Mytree {

    String data ;

    Mytree leftChild = null;

    Mytree rightChild = null;

    public Mytree(String data){
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Mytree getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Mytree leftChild) {
        this.leftChild = leftChild;
    }

    public Mytree getRightChild() {
        return rightChild;
    }

    public void setRightChild(Mytree rightChild) {
        this.rightChild = rightChild;
    }
}
