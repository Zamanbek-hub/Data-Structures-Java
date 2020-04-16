package com.company.Week4.Task1;

import java.util.NoSuchElementException;

class Node<T>{
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
}


//при ДаблЛисте когда адд надо расчитать с какой стороны удобно бежать
// if boolean true head else tail
//  if index more than size its equals to tail


//Task 3
// addSorted() при добавке надо сразу же отсортировать like set on C++
//


// each Task should be seperate class on seperate package


class LinkedList<T>{
    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;

    public void add(T obj){
        if(head == null){
            head = new Node<T>(obj);
        }
        else{
            Node<T> last = head;
            while(last.hasnext()){
                last = last.getNext();
            }
            last.setNext(new Node <T>(obj));
        }

        size++;
    }

    public void addFirst(T obj){
        Node<T> newobj = new Node<T>(obj);
        newobj.setNext(head);
        head = newobj;
    }

    public void add(int index, T obj) {
        if(index == 0)
            addFirst(obj);
        else if (index < size) {
            int counter = 0;
            Node<T> last = head;
            while (counter < index) {
                System.out.println("we are here 1");
                counter++;
                if (counter == index) {
                    System.out.println("we are here 2");
                    Node<T> newobj = new Node<T>(obj);
                    newobj.setNext(last.getNext());
                    last.setNext(newobj);
                }
                last = last.getNext();
            }
            size++;
        }
        else {
            System.out.println("We are");
            add(obj);
        }

    }

    public void add(LinkedList<T> list){
        Node<T> temp = list.head;
        while(temp != null){
            add(temp.getData());
            temp = temp.getNext();
        }
    }

    public void  clear(){
        head = null;
        size = 0;
        head.setNext(null);

    }

    public LinkedList<T> clone(){
        LinkedList<T> copy = new LinkedList<>();
        copy.setHead(new Node<T>(head.getData()));
        Node<T> temp = head;
        Node<T> tempcopy = copy.head;
        while (temp.hasnext()){   ///hashmap
            tempcopy.setNext(new Node<T>(temp.getNext().getData()));
            tempcopy = tempcopy.getNext();
            temp = temp.getNext();
        }
        return copy;
    }


    public T get(int index){
        int counter = 0;
        Node<T> temp = head;
        T obj = getLast();
        if(index < size) {
            do {
                counter++;
                obj = temp.getNext().getData();
                temp = temp.getNext();
            }
            while (counter < index);
        }
        return obj;

    }

    public T getFirst(){
        T obj = head.getData();
        return obj;
    }

    public  T getLast(){
        T obj = null;
        int counter = 0;
        Node<T> temp = head;
        do {
            counter++;
            obj = temp.getData();
            temp = temp.getNext();
        }
        while (counter < size);
        return obj;
    }

    public int indexOf(T obj){
        Node<T> temp = head;
        int counter = 0;
        do {
            if(temp.getData().equals(obj))
                break;

            temp = temp.getNext();
            counter++;
        }
        while (counter < size);
        return counter;
    }



    public String toString(){
        String all = "";

        Node<T> current = head;
        while(current != null){
            all += (current.getData() + "\n");
            current = current.getNext();
        }
        return all;
    }

    public void remove(){
        if (size == 0)
            throw new NoSuchElementException();
        setHead(head.getNext());
        size--;
    }

    public void removelast(){
        int counter = 0;
        Node<T> temp = head;
        do {
            counter++;
            if(counter == size - 1){
                temp.setNext(null);
            }
            else {
                temp = temp.getNext();
            }
        }
        while (counter < size);
        size--;
    }

    public void remove(int index){
        if (size == 0)
            throw new NoSuchElementException();
        if(index == 0){
            head = head.getNext();
        }
        else if(index >= size - 1)
            removelast();
        else{
            int counter = 1;
            Node<T> last = head;
            while (counter < index) {
                last = last.getNext();
                counter++;
                if (counter == index) {
                    last.setNext(last.getNext().getNext());
                }
            }
            size--;
        }


    }


    public void remove(T data){
        if(head.getData().equals(data)) {
            head = head.getNext();
        }
        else {
            Node<T> remove = head;

            while(remove.getNext() != null){
                System.out.println( "Exp - " + remove.getNext().getData());
                if(remove.getNext().getData().equals(data)){
                    System.out.println("We are here 2");
                    if(remove.getNext().getNext() != null) {
//                        remove.setNext(remove.getNext().getNext());
                    }
                    else {
                        remove.setNext(null);
                    }
                }
                remove = remove.getNext();
            }
        }
        size--; //Todo do yourself
    }

    public void set(int index, T obj){
        if(index == 0){
            Node<T> newobj = new Node<T>(obj);
            newobj.setNext(head.getNext());
            head = newobj;
        }

        else if (index < size) {
            int counter =0;
            Node<T> last = head;
            while (counter < index) {
                counter++;
                if (counter == index) {
                    Node<T> newobj = new Node<T>(obj);
                    newobj.setNext(last.getNext().getNext());
                    last.setNext(newobj);
                }
                last = last.getNext();
            }
        }
        else {
            add(obj);
        }
    }

    public void print(boolean istrue){
        String all = "";
        Node<T> current = head;
        if(istrue){
            while(current != null){
                all += (current.getData() + "\n");
                current = current.getNext();
            }

        }
        else{
            while(current != null){
                all = (current.getData() + "\n" + all);
                current = current.getNext();
            }
        }
        System.out.println(all);
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
}


