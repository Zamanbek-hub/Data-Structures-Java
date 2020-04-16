package com.company.Week8.BinarySearchTree;

public class main {
    public static void  main(String []args){
        BinarySearchTree<Integer> Tree = new BinarySearchTree<>();
//        Tree.insert(35);
//        Tree.insert(30);
//        Tree.insert(45);
//        Tree.insert(28);
//        Tree.insert(38);
//        Tree.insert(40);
//        Tree.insert(47);
//        Tree.insert(59);
//        Tree.insert(8);
//        Tree.insert(1);
//        System.out.println("Root = " + Tree.getRoot().getData());
//        Tree.delete(5);
//        Tree.postOrder();
        Tree.insert(7);
        Tree.insert(5);
        Tree.insert(2);
        Tree.insert(6);
        Tree.insert(8);
        Tree.insert(1);
        Tree.insert(4);

        Tree.levelOrder();
//        System.out.println("Yeaaaaaaaa");
//        System.out.println("Root = " + Tree.getRoot().getData());
////        System.out.println(Tree.find(5).getData());
//        System.out.println(Tree.largest());
    }
}
