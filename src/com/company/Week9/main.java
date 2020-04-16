package com.company.Week9;

public class main {
    public static void main(String fuck[]){
        AVLTree<Integer> tree = new AVLTree<>();
        tree.insert(13);
        tree.insert(10);
        tree.insert(15);
        tree.insert(5);
        tree.insert(11);
        tree.insert(4);
        tree.insert(6);
        tree.insert(16);
        tree.insert(7);
//        tree.insert(3);
//        tree.insert(9);

        tree.delete(4);
        tree.delete(11);


        System.out.println("Bal = " + tree.Balance(tree.root, 5));
        System.out.println("Left = " + tree.get(tree.root, 5).getHeihgt());
        tree.levelOrder();
    }
}
