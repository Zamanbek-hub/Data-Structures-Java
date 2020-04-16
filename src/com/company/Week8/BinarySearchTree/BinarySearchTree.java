package com.company.Week8.BinarySearchTree;

class Node<T extends Comparable<T>>{
    private T data;
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

    //    public T getData(){
//        return data;
//    }
}

public class BinarySearchTree<T extends Comparable<T>> {
    Node<T> root;
    BinarySearchTree(){
        root = null;
    }

    public void insert( T obj){
        root = unseen_Insert(root,  obj);
    }

    private Node<T> unseen_Insert(Node<T> root, T obj){
        if(root == null) {
            root = new Node<T>(obj);
            return root;
        }

        if(obj.compareTo(root.getData()) > 0)
            root.setRight(unseen_Insert(root.getRight(), obj));
        else if(obj.compareTo(root.getData()) < 0)
            root.setLeft(unseen_Insert(root.getLeft(), obj));

        return root;
    }

    public void delete(T obj){
        root = unseen_Delete(root,  obj);
    }

    public Node<T> get(Node<T> root,T obj ) {
        if (obj.compareTo(root.getData()) > 0)
            return get(root.getRight(), obj);
        else if (obj.compareTo(root.getData()) < 0)
            return get(root.getLeft(), obj);

        return root;
    }
    private Node<T> unseen_Delete(Node<T> root, T obj){
//        System.out.println("in unseen_Delete");
        if(root == null)
            return null;


        if(obj.compareTo(root.getData()) > 0)
            root.setRight(unseen_Delete(root.getRight(), obj));
        else if(obj.compareTo(root.getData()) < 0)
            root.setLeft(unseen_Delete(root.getLeft(), obj));
        else{

            if(root.getLeft() == null)
                return root.getRight();

            else if(root.getRight() == null)
                return root.getLeft();
            root.setData(unseenlargest(root.getLeft()).getData());
            root.setLeft(unseen_Delete(root.getLeft(), root.getData()));
            return root;

        }
        return root;
    }


    public void inOrder()  {
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(Node root) {
        if (root == null) return;
        inorderRec(root.getLeft());
        System.out.print(root.getData() + " ");
        inorderRec(root.getRight());

    }

    public void preOrder(){
        unseen_preOrder(root);
        System.out.println();
    }

    private void unseen_preOrder(Node root){
        if(root == null) return;
        System.out.println(root.getData());
        unseen_preOrder(root.getLeft());
        unseen_preOrder(root.getRight());
    }

    public void postOrder(){
        unseen_postOrder(root);
        System.out.println();
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
        if(level == 1) System.out.print(root.getData() + " ");
        else if(level > 1){
            unseen_levelOrder(root.getLeft(), level - 1);
            unseen_levelOrder(root.getRight(), level - 1);
        }
    }

    private void unseen_postOrder(Node root){
        if(root == null) return;
        unseen_postOrder(root.getLeft());
        unseen_postOrder(root.getRight());
        System.out.println(root.getData());
    }

    public Node<T> find(T obj){
        return unseen_find(root, obj);
    }

    private Node<T> unseen_find(Node<T> root, T obj){
        if(root == null)
            return null;

        if(obj.compareTo(root.getData()) > 0)
            root = unseen_find(root.getRight(), obj);
        else if(obj.compareTo(root.getData()) < 0)
            root = unseen_find(root.getLeft(), obj);

        return root;
    }

    public T smallest(){
        return unseensmallest( root).getData();
    }

    private Node<T> unseensmallest(Node<T> root){
        if(root.getLeft() == null)
            return root;
        return unseensmallest(root.getLeft());
    }

    public T largest(){
        return unseenlargest( root).getData();
    }

    private Node<T> unseenlargest(Node<T> root){
        if(root.getRight() == null)
            return root;
        return unseenlargest(root.getRight());
    }

    public Node<T> getRoot() {
        return root;
    }
}
