package com.company.Week5.Task2;

public class PriorityDeque<T extends Comparable<T>> {
    private T[] deque = null;
    private int head = -1;
    private int last = 0;
    private int size = 0;
    private int length = 16;

    PriorityDeque(){
        deque = (T[])new Comparable[length];
    }

    PriorityDeque(int givensize){
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
        System.out.println("last index = " + last);
        System.out.println("head index = " + head);
        return deque[last - 1];
    }

    public void doubleCapacity(){
        int diff = difference();
//        System.out.println("diff = " + diff);
        T[] deque1 = (T[]) new Comparable[length + 10];

        for(int i = 0; i < last + diff; i++) {
            if (i < diff)
                deque1[i] = deque[(last + (head - last) + i) % length];
            else
                deque1[i] = deque[i - diff];
//            System.out.println("i = " + i);
        }
        this.deque = deque1;

        length += 10;
        head = 0;
        last = last + diff;

    }

    public void shiftHead(int index, T obj){
        int diff = difference(index);

        for(int i = 0; i < diff; i++) {
            deque[((head + i) % length) - 1] = deque[(head + i) % length];
        }
        deque[index] = obj;
    }



    public void shift(int index, T obj){
        int diff = difference(index);

        for(int i = toLoop(index); i >= 0; i--) {

            if ((last - (toLoop(index) - i) + 1) <= 0)
                deque[(last - (toLoop(index) - i) + 1)] = deque[length - 1];
            else deque[(last - (toLoop(index) - i)) + 1] = deque[((last - (toLoop(index) - i)))];

        }

        deque[index] = obj;
    }

    public void insert(T obj ){
        if (isEmpty() || obj.compareTo(deque[last - 1]) >= 0){
            addLast(obj);
            return;
        }
        else if((head == 0 && (obj.compareTo(deque[0]) < 0)) || obj.compareTo(deque[head]) <= 0){
            addFirst(obj);
            return;
        }


        int diff = difference();

        for(int i = 0; i < size; i++) {
            if (i < diff) {
                if (obj.compareTo(deque[(last + (head - last) + i) % length]) <= 0) {
                    head = head - 1;
                    shiftHead((last + (head - last) + i) % length, obj);
                    break;
                }
            }
            else {
                    if (obj.compareTo(deque[i - diff]) <= 0) {
                        last = last + 1;
                        shift(i - diff, obj);
                        break;
                    }
                }
        }
        size++;
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

    private void addLast(T obj){
        if(isFull()) {

            doubleCapacity();
        }

        if (head == -1)
            head = 0;

        if(last == length - 1)
            last = 0; // nedd to thing
        else last = last + 1;
        deque[last - 1] = obj;

        size++;
    }

    public T remove(){
        if(isEmpty()) {
            System.out.println("Empty");
            return null;
        }

        if(last == 0)
            last = length - 1;
        last = last - 1;

        if(head == last)
            head = -1;

        size--;
        return deque[last-1];
    }

    public T peek(){
        return deque[last-1];
    }




    @Override
    public String toString(){
        if(isEmpty())
            return "Empty";

        String all = "";
        int diff = difference();

        for(int i = 0; i < last + diff; i++) {
            if (i < diff) {
                all += (last + (head - last) + i) % length + " = " + deque[(last + (head - last) + i) % length].toString() + ", ";
            }
            else {

                all +=  i - diff + " = " + deque[i - diff].toString() + ", ";
            }
        }

        return "[" + all.substring(0,all.length() - 2) + "]";
    }


    private int difference(){
        if(head < length / 2) return length - (length - head);
        else return length - head;

    }

    private int difference(int index){
        if(index < length / 2)
            return 0;
        else
            return length - index;
    }

    private int toLoop(int index){
        if((index >= 0 && index < length / 2))
            return last - index;
        else if(index > length / 2)
            return last + (length - index);
        return 0;
    }

}

