package com.company.Week8.ExpressionTree;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

class Node<T extends Comparable<T>>{
    private char operator = '#';
    private double num = -1;
    private Node<T> left;
    private Node<T> right;
    private Node<T> parent;

    public Node(){
        left = right = parent = null;
    }

    public int compareTo(int number){
        if(this.num > number)
            return 1;
        else if(this.num < number)
            return -1;
        return 0;
    }



    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public double getNum() {
        return num;
    }

    public void setNum(double num) {
        this.num = num;
    }

    public char getOperator() {
        return operator;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }

    public boolean what(){
        return operator == '#';
    }

    public Node<T> getParent() {
        return parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }
}

public class ExpressionTree<T extends Comparable<T>> {
    private Node<T> root;
    ExpressionTree(){
        root = null;
    }

    private boolean isOperator(char c) {
        if (c == '+' || c == '-'
                || c == '*' || c == '/')
            return true;

        return false;
    }

    private boolean isPlusMinus(char c){
        if(c == '+' || c == '-')
            return true;

        return false;
    }

    public void construct_Tree(String str){
        if(str.equals(""))
            System.out.println("Error");

        char []task = str.toCharArray();
        unseen_construct(task, 0 , task.length-1);

    }

    private boolean checktoZero(Node temp){
        if(root.getOperator() == '/' && temp.getNum() == 0)
            return true;
        return false;

    }

    private void unseen_construct(char []task, int head, int tail){
        Node<T> node = new Node<>();
        node.setNum(Character.getNumericValue(task[tail]));
        root = node;

        int  i = tail - 1;
        while(i >= 0){
            Node<T> temp = new Node<>();
            if(isOperator(task[i])){
                if(isPlusMinus(task[i])){
                    while (root.getParent() != null){
                        if(isPlusMinus(root.getParent().getOperator())) {

                            root.getParent().setLeft(temp);
                            temp.setParent(root.getParent());
                            break;
                        }
                        root = root.getParent();
                    }
                }
                else{
                    if(root.getParent() != null) {
                        root.getParent().setLeft(temp);
                        temp.setParent(root.getParent());
                    }

                }
                temp.setOperator(task[i]);
                temp.setRight(root);
                root.setParent(temp);
            }
            else {
                temp.setNum(Character.getNumericValue(task[i]));
                temp.getNum();

                root.setLeft(temp);
                temp.setParent(root);
            }
            root = temp;
            i--;
        }

        findroot();
    }

    public void findroot(){
        while(root.getParent() != null)
            root = root.getParent();
    }

    public void inorder()  {
        inorderRec(root);
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.getLeft());
            if(root.getParent() != null){
                if(root.what())
                    System.out.println("root here = " + root.getNum() + " root parent = " + root.getParent().getOperator());
                else
                    System.out.println("root here = " + root.getOperator() + " root parent = " + root.getParent().getOperator());

            }
            inorderRec(root.getRight());
        }
    }

    public double solve(){
        return unseen_solve(root);
    }

    private double unseen_solve(Node root){
        double  left, right;
        if(root == null) return 0;
        left = unseen_solve(root.getLeft());
        right = unseen_solve(root.getRight());
        if (root.what())
            return root.getNum();
        else {
            if(root.getOperator() == '+')
                return left + right;

            else if(root.getOperator() == '-')
                return left - right;

            else if(root.getOperator() == '*')
                return left* right;

            else if(root.getOperator() == '/')
                return left / right;

        }
        return 0;
    }

    private int height(Node root){
        if(root == null) return 0;
        else {
            int left = height(root.getLeft());
            int right = height(root.getRight());

            if(left > right) return(left + 1);
            else return right + 1;

        }
    }

    public void levelOrder() {
        int h = height(root);
        for (int i = 1; i <= h; i++) {
            unseen_levelOrder(root, i);
            System.out.println();
        }
    }

    private void unseen_levelOrder(Node root, int level){
        if(root == null) {
            System.out.print("#" + " ");
            return;
        }
        if(level == 1) {
            if (root.what())
                System.out.print(root.getNum() + " ");
            else System.out.print(root.getOperator() + " ");
        }

        else if(level > 1){
            unseen_levelOrder(root.getLeft(), level - 1);
            unseen_levelOrder(root.getRight(), level - 1);
        }
    }
}
