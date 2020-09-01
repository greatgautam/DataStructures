package com.dataStructureQs.recursion;

class Node{
    int value;
    Node right;
    Node left;

    Node(int value){
        this.value = value;
        this.right = null;
        this.left = null;
    }
}
public class BinaryTree {
    Node root;

    private Node addRecursive(Node current, int value){
        if (current == null){
            return new Node(value);
        }
        if (current.value > value ){
            current.left = addRecursive(current.left, value);
        }else if (current.value < value){
            current.right = addRecursive(current.right, value);
        }else{
            return current;
        }

        return current;
    }

    public void add(int value){
        root = addRecursive(root, value);
    }

    public int heightRecursive(Node root){
        if (root == null){
            return 0;
        }
        int leftHeight = heightRecursive(root.left);
        int rightHeight = heightRecursive(root.right);
        return 1 + Math.max(leftHeight,rightHeight);
    }

    public void traversePostOrder(Node node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.print(" " + node.value);
        }
    }

    public void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.value);
            traverseInOrder(node.right);

        }
    }
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.add(10);
        tree.add(9);
        tree.add(14);
        tree.add(7);
        tree.add(6);

        tree.traversePostOrder(tree.root);
        System.out.println("");
        tree.traverseInOrder(tree.root);
        System.out.println("");
        System.out.println("Tree height is = "+tree.heightRecursive(tree.root));
    }
}
