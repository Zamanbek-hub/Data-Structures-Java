package com.company.Week9;

public class main {
    public static void main(String fuck[]){
        AVLTree<Integer> tree = new AVLTree<>();
        tree.insert(30);
        tree.insert(20);
        tree.insert(50);
        tree.insert(70);
        tree.insert(60);

//        tree.insert(3);
//        tree.insert(9);

//        tree.delete(4);
//        tree.delete(11);


//        System.out.println("Bal = " + tree.Balance(tree.root, 5));
//        System.out.println("Left = " + tree.get(tree.root, 5).getHeihgt());
        tree.levelOrder();
    }
}
