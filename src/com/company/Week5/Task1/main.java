package com.company.Week5.Task1;

import com.company.Week5.Task1.ArrayDeque;

public class main {
    public static void main(String []args){
        ArrayDeque<Integer> deque = new ArrayDeque<>(10);
        System.out.println(deque.isFull());
        deque.addFirst(4);
        deque.addFirst(3);
        deque.addLast(5);
        deque.addFirst(2);
        deque.addFirst(1);
        deque.addLast(6);
        deque.addLast(7);
        deque.addLast(8);
        deque.addLast(9);
        System.out.println("size = " + deque.size());
        deque.addFirst(0);
        System.out.println("size = " + deque.size());
        System.out.println(deque);
        deque.addLast(10);
        System.out.println("size = " + deque.size());
        System.out.println(deque);
        deque.addFirst(4);
        deque.addFirst(3);
        deque.addLast(5);
        deque.addFirst(2);
        deque.addFirst(1);

        deque.addLast(6);
        deque.addLast(7);
        deque.addLast(8);
        deque.addLast(9);
        System.out.println("size = " + deque.size());
        deque.addFirst(9);
        System.out.println("size = " + deque.size());
        System.out.println("Firse = " + deque.first());
        System.out.println("Last = " + deque.last());
        System.out.println(deque);

//
        deque.removeLast();
        System.out.println(deque);
        deque.removeFirst();
        System.out.println(deque);

    }
}
