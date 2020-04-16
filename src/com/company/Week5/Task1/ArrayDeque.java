package com.company.Week5.Task1;

public class ArrayDeque<T extends Comparable<T>> {
    private T[] deque = null;
    private int head = -1;
    private int last = 0;
    private int size = 0;
    private int length = 16;

    ArrayDeque(){
        deque = (T[])new Comparable[length];
    }

    ArrayDeque(int givensize){
        deque = (T[])new Comparable[givensize];
        length = givensize;
    }

    public String size(){
        return "size = " + Integer.toString(size) + " length = " + Integer.toString(length);
    }

    public boolean isEmpty(){
        return (head == -1);
    }

    public boolean isFull(){
//        return(!(head == 0 && last == 0) && (head == last));
        return (head == last);
    }

    public T first(){
        return deque[head];
    }

    public T last(){
        return deque[last - 1];
    }

    public void doubleCapacity(){
        int diff = difference();

        T[] deque1 = (T[]) new Comparable[length + 10];

        for(int i = 0; i < size; i++) {
            if (i < diff)
                deque1[i] = deque[(last + (head - last) + i) % length];
            else
                deque1[i] = deque[i - diff];

        }
        this.deque = deque1;

        length += 10;
        head = 0;
        last = last + diff;

    }

    public void addFirst(T obj){
        if(isFull()) {
            doubleCapacity();
        }

        if(head == -1)
            head = 0;

        if(head == 0)
            head = length - 1;
        else head = head - 1;

        deque[head] = obj;

        size++;
    }

    public void addLast(T obj){
        if(isFull()) {
            doubleCapacity();
        }

        if (head == -1)
            head = 0;

        if(last == length - 1)
            last = 0; // need to thing
        else last = last + 1;
        deque[last - 1] = obj;

        size++;
    }

    public void removeLast(){
        if(isEmpty()) {
            System.out.println("Empty");
            return;
        }

        if(last == 0)
            last = length - 1;
        else
            last = last - 1;

        if(head == last)
            head = -1;

        size--;
    }

    public void removeFirst(){
        if(isEmpty()) {
//            System.out.println("Empty");
            return;
        }
        if(head == length - 1)
            head = 0;
        else
            head = head + 1;
//        System.out.println("head = " + head);
        if(head == last)
            head = -1;

        size--;
    }

     @Override
    public String toString(){
        if(isEmpty())
            return "Empty";

        String all = "";
        int diff = difference();

        System.out.println("diff = " + diff);
        for(int i = 0; i < size; i++) {
            if (i < diff) {
//                System.out.println("head = " + head + " last = " + last);
//                System.out.println("index = " + (last + (head - last) + i) % length);
//                System.out.println("In 1 = " + deque[(last + (head - last) + i) % length].toString());
                all += (last + (head - last) + i) % length + " = " + deque[(last + (head - last) + i) % length].toString() + ", ";
            }
            else {
//                System.out.println("In 2 = " + deque[i - diff].toString());
                all +=  i - diff + " = " + deque[i - diff].toString() + ", ";
            }
//            System.out.println("i = " + i);
        }

        return "[" + all.substring(0,all.length() - 2) + "]";
    }


    private int difference(){
        if(head < length / 2)
            return length - (length - head);
        else
            return length - head;
    }


//    private int toLoop(){
//        if((head > 0 && head < length / 2) && (last < length - 1 && last > head))
//            return last - difference();
//        else if(head > length / 2 && (last < head &&  last > 0)  )
//            return last + difference();
//        return 0;
//    }


}
