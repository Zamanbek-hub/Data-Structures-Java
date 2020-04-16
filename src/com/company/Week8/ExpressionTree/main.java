package com.company.Week8.ExpressionTree;

public class main {
    public static void  main(String []args){
        ExpressionTree<Integer> Tree = new ExpressionTree<>();
//        Tree.construct_Tree("4+5*8/2-3");
//        Tree.construct_Tree("5+3*6/2-2");
        Tree.construct_Tree("4*3-6/2-5*3-1+9");

        Tree.levelOrder();
        System.out.println("Answer : " + Tree.solve());
    }
}
