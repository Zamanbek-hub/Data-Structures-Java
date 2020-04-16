package com.company.Week4.Task3;

import java.util.Iterator;

class Node<T extends Comparable<T>>{
    private T data;
    private Node<T> next = null;
    private Node<T> previous = null;

    public Node(T data){
        this.data = data;
    }

//    public T getData(){
//        return data;
//    }
    public boolean hasnext(){
        return next!= null;
    }

    public boolean hasprevious(){
        return previous!= null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    public int compareTo(T obj){
        if(this.data.compareTo(obj) > 0)
            return 1;
        else if(this.data.compareTo(obj) < 0)
            return -1;
        return 0;
    }

}

public class LinkedList<T extends Comparable<T>> {
    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;

    public void sort(Node<T> newobj){

    }


    public void addSorted(T obj){
        Node<T> newobj = new Node<>(obj);
        if(size == 0){
            head = newobj;
            tail = head;
        }
        else {
            int counter = 0;
            Node<T> temp = head;
            do {
                if (newobj.compareTo(temp.getData()) > 0)
                    if(temp.hasnext())
                        temp = temp.getNext();
                    else
                        break;


                else {
                    counter++;
                    if(temp.equals(head))
                        add(obj,true);

                    else {
                        newobj.setNext(temp);
                        newobj.setPrevious(temp.getPrevious());
                        newobj.getPrevious().setNext(newobj);
                        temp.setPrevious(newobj);
                    }

                    break;
                }
                print(true);
            }
            while (temp.hasnext());

            if(counter == 0)
                add(obj, false);
        }
        size++;
    }

    public void add(T obj, boolean where){
        Node<T> newobj = new Node<>(obj);
        if(head == null){
            head = newobj;
            tail = head;
        }
        if(where){
            newobj.setNext(head);
            head.setPrevious(newobj);
            this.head = newobj;
        }
        else{
            tail.setNext(newobj);
            newobj.setPrevious(tail);
            this.tail = newobj;
        }
        size++;
    }

    public void add(int index, T obj){
        Node<T> newobj = new Node<>(obj);
        if(head == null)
            add(obj,true);
        if(index == 0){
            newobj.setNext(head);
            head.setPrevious(newobj);
            head = newobj;
        }
        else if(index == size - 1 || index >= size || index < 0){
            tail.setNext(newobj);
            newobj.setPrevious(tail);
            tail = newobj;
        }
        else {
            Node<T> temp = search(index);
            newobj.setNext(temp);
            newobj.setPrevious(temp.getPrevious());
            newobj.getPrevious().setNext(newobj);
            temp.setPrevious(newobj);
            System.out.println("we in" + newobj.getData());
        }
        size++;
    }

    public Node<T> search(int index){
        int counter = 0;
        Node<T> find = null;
        System.out.println("size in search = " + size/ 2);
        if(index < size / 2){
            counter = -1;
            System.out.println("We are in head");
            Node<T> temp = head;
            do {
                find = temp;
                temp = temp.getNext();
                counter++;
            }while(counter<index);
        }
        else{
            System.out.println("We are in tail");
            Node<T> temp = tail;
            do {
                find = temp;
                temp = temp.getPrevious();
                counter++;
            }while(counter<(size - index));
        }
        return find;
    }

    public T get(int index){
        return search(index).getData();
    }

    public T getFirst(){
        return head.getData();
    }

    public T getLast(){
        return tail.getData();
    }

    public void print(boolean istrue){
        String all = "";
        if(istrue){
            Node<T> current = head;
            while(current != null){
                all += (current.getData() + "\n");
                current = current.getNext();
            }

        }
        else{
            System.out.println("we are in tail " + tail.getData());
            Node<T> current = tail;
            while(current != null){
                all += (current.getData() + "\n");
                current = current.getPrevious();
            }
        }
        System.out.println(all);
    }

    public void remove(boolean where){
        if(where){
            head.getNext().setPrevious(null);
            head = head.getNext();
        }
        else{
            tail.getPrevious().setNext(null);
            tail = tail.getPrevious();
        }
    }

    public void remove(int index){
        Node<T> temp = search(index);

        if(index == 0)
            remove(true);
        else if(index == size-1 || index >= size || index < 0) // here we should some changes
            remove(false);
        else {
            temp = temp.getNext();
            temp.setPrevious(temp.getPrevious().getPrevious());

            temp = temp.getPrevious();
            temp.setNext(temp.getNext().getNext());
        }
    }

    public void set(int index, T obj){
        Node<T> temp = search(index);
        Node<T> newobj = new Node<>(obj);
        if(head == null)
            add(obj,true);
        if(index == 0){
            newobj.setNext(head.getNext());
            head.getNext().setPrevious(newobj);
            head = newobj;

        }
        else if(index == size-1 || index >= size || index < 0){
            newobj.setPrevious(tail.getPrevious());
            tail.getPrevious().setNext(newobj);
            tail = newobj;
        }
        else {
            newobj.setNext(temp.getNext());
            newobj.setPrevious(temp.getPrevious());
            temp.getPrevious().setNext(newobj);
            temp.getNext().setPrevious(newobj);
        }
    }

    public int size(){
        return size;
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public void setTail(Node<T> tail) {
        this.tail = tail;
    }

}
