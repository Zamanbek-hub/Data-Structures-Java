package com.company.Week9;

class Node<T extends Comparable<T>>{
    private T data;
    private int heihgt;
    private Node<T> left;
    private Node<T> right;

    public Node(T data){
        this.data = data;
        left = right = null;
    }

    public int compareTo(T obj){
        if(this.data.compareTo(obj) > 0)
            return 1;
        else if(this.data.compareTo(obj) < 0)
            return -1;
        return 0;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
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

    public int getHeihgt() {
        return heihgt;
    }

    public void setHeihgt(int heihgt) {
        this.heihgt = heihgt;
    }

    //    public T getData(){
//        return data;
//    }
}

public class AVLTree<T extends Comparable<T>> {
    Node<T> root = null;
    AVLTree(){
        root = null;
    }

    private int max(int a, int b){
        return (a > b) ? a : b;
    }

    public int height(Node current){
        if(current == null)
            return 0;
        return current.getHeihgt();
    }

    public int heightd(Node current){
        if(current == null)
            return 0;
        return current.getHeihgt() + 1;
    }

    public int getHEight(T obj){
        Node<T> node = root;
        return getheight(node, obj);
    }
    private int getheight(Node<T> node, T obj){
        if(obj.compareTo(node.getData()) > 0)
            return getheight(node.getRight(), obj);
        else if(obj.compareTo(node.getData()) < 0)
            return getheight(node.getLeft(), obj);
        else return node.getHeihgt();

    }

    private int getBalance(Node current){
        if(current == null)
            return 0;
        return height(current.getLeft()) - height(current.getRight());
    }

    private int getBalanced(Node current){
        if(current == null)
            return 0;
        return heightd(current.getLeft()) - heightd(current.getRight());
    }

    public Node<T> get(Node<T> node, T obj){
        if(obj.compareTo(node.getData()) > 0)
            return get(node.getRight(), obj);
        else if(obj.compareTo(node.getData()) < 0)
            return get(node.getLeft(), obj);
        else return node;
    }

    public int Balance(Node<T> node, T obj){
        if(obj.compareTo(node.getData()) > 0)
            return Balance(node.getRight(), obj);
        else if(obj.compareTo(node.getData()) < 0)
            return Balance(node.getLeft(), obj);
        else return height(node.getLeft()) - height(node.getRight());
    }

    private  Node<T> rightRotate(Node y){
        Node x = y.getLeft();
        Node T2 = x.getRight();


        x.setRight(y);
        y.setLeft(T2);

        y.setHeihgt(max(height(y.getLeft()),height(y.getRight())) + 1);
        x.setHeihgt(max(height(x.getLeft()),height(x.getRight())) + 1);

        return x;
    }

    private Node<T> leftRotate(Node x){
        Node y = x.getRight();
        Node T2 = y.getLeft();

        y.setLeft(x);
        x.setRight(T2);

        x.setHeihgt(max(height(x.getLeft()),height(x.getRight())) + 1);
        y.setHeihgt(max(height(y.getLeft()),height(y.getRight())) + 1);

        return y;
    }


    public void insert(T obj){
        root = unseen_insert(root, obj);
    }



    private Node<T> unseen_insert(Node<T> node, T obj){
        if(node == null) {
            Node<T> node1 =  new Node<>(obj);
            return node1;
        }

        if(obj.compareTo(node.getData()) > 0)
            node.setRight(unseen_insert(node.getRight(), obj));
        else if(obj.compareTo(node.getData()) < 0)
            node.setLeft(unseen_insert(node.getLeft(), obj));
        else return node;

        node.setHeihgt(1 + max(height(node.getLeft()), height(node.getRight())));
        int  balance = getBalance(node);

        if(balance > 1 && obj.compareTo(node.getLeft().getData()) < 0)
            return rightRotate(node);

        if(balance < -1 && obj.compareTo(node.getRight().getData()) > 0)
            return leftRotate(node);

        if(balance > 1 && obj.compareTo(node.getLeft().getData()) > 0) {
            node.setLeft(leftRotate(node.getLeft()));
            return rightRotate(node);
        }

        if(balance < -1 && obj.compareTo(node.getRight().getData()) < 0){
            node.setRight(rightRotate(node.getRight()));
            return leftRotate(node);
        }

        return node;

    }

    public void delete(T obj){
        root = unseen_Delete(root, obj);
    }

    private Node<T> unseen_Delete(Node<T> node, T obj){

        if(node == null)
            return null;


        if(obj.compareTo(node.getData()) > 0)
            node.setRight(unseen_Delete(node.getRight(), obj));
        else if(obj.compareTo(node.getData()) < 0)
            node.setLeft(unseen_Delete(node.getLeft(), obj));
        else{

            if(node.getLeft() == null) {

                return node.getRight();

            }

            else if(node.getRight() == null)
                return node.getLeft();
            node.setData(unseenlargest(node.getLeft()).getData());
            node.setLeft(unseen_Delete(node.getLeft(), node.getData()));
            return node;

        }
        if (node == null)
            return root;

        node.setHeihgt(1 + max(height(node.getLeft()), height(node.getRight())));

        int  balance = getBalanced(node);

//        System.out.println("root = " + node.getData());
//        System.out.println("balance = " + getBalance(node));
        if(balance > 1 && getBalance(node.getLeft()) >= 0)
            return rightRotate(node);

        if(balance < -1 && getBalance(node.getRight()) <= 0)
            return leftRotate(node);

        if(balance > 1 && getBalance(node.getLeft()) < 0) {
            node.setLeft(leftRotate(node.getLeft()));
            return rightRotate(node);
        }

        if(balance < -1 &&  getBalance(node.getRight()) > 0){
            node.setRight(rightRotate(node.getRight()));
            return leftRotate(node);
        }

        return node;
    }



    private Node<T> unseenlargest(Node<T> root){
        if(root.getRight() == null)
            return root;
        return unseenlargest(root.getRight());
    }

    public int Height(Node root){
        if(root == null) return 0;
        else {
            int left = height(root.getLeft());
            int right = height(root.getRight());

            if(left > right) return(left + 2);
            else return right + 2;

        }
    }



    public void levelOrder() {
        int h = Height(root);
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
        if(level == 1) System.out.print(root.getData() + " ");
        else if(level > 1){
            unseen_levelOrder(root.getLeft(), level - 1);
            unseen_levelOrder(root.getRight(), level - 1);
        }
    }


}
