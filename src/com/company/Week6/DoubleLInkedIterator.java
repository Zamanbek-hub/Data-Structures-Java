package com.company.Week6;

import java.util.Iterator;

public class DoubleLInkedIterator<T extends Comparable<T>> implements Iterator<T> {
    private Node<T> current;
    private boolean ishead;


    public DoubleLInkedIterator(DoubleLinkedList<T> list, boolean istail){
        this.ishead = istail;
        if (ishead)
            current = list.getHead();
        else
            current = list.getTail();

    }

    @Override
    public boolean hasNext() {
        return (current != null);
    }




    public T next() {
        T obj = current.getData();

        if (ishead)
            current = current.getNext();
        else
            current = current.getPrevious();

        return obj;
    }


}
