package com.company.Week5.Task2;

import java.util.PriorityQueue;

public class main {

    public static void main(String []args) {
      PriorityDeque<Integer> deque = new PriorityDeque<>();
      deque.insert(10);
        System.out.println(deque);
      deque.insert(2);
        System.out.println(deque);
      deque.insert(7);
        System.out.println(deque);
      deque.insert(12);
        System.out.println(deque);
      deque.insert(-1);
        System.out.println(deque);
        deque.insert(6);
        System.out.println(deque);
        deque.insert(8);
        System.out.println(deque);
        deque.insert(9);
        System.out.println(deque);
        deque.insert(5);
        System.out.println(deque);
        deque.insert(1);
        System.out.println(deque);
        deque.insert(0);
        System.out.println(deque);
        deque.insert(4);
        System.out.println(deque);

        deque.remove();
        System.out.println(deque.peek());

    }
}
