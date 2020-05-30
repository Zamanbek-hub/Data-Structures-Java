package com.company.Week3.Task1;

public class Vector<T extends Comparable<T>>  {
    private int size = 0;
    private int currentSize = 10;
    private T[] vector;

    public Vector(){vector =  (T[])new Comparable[currentSize]; }


    public T get(int index){
        return vector[index];
    }

    public void increseordecrease(boolean what){
        if(what)
            this.currentSize += 10;
        else {
            this.currentSize /= 2;
//            System.out.println("currentsize = " + currentSize);
        }
        T[] vector1 = (T[])new Comparable[currentSize];

        for(int i =0; i < size; i++)
            vector1[i] = vector[i];

        this.vector = vector1;
    }



    public void add(T obj){
        if(size < currentSize) {
            vector[size] = obj;
            ++size;
        }
        else if(size == currentSize){
            increseordecrease(true);
            add(obj);
        }
    }

    public void remove(int index){
        if(index < 0 || index > size)
            System.out.println("OutofArray");
        else {
            for (int i = index; i < size - 1; i++)
                vector[i] = vector[i + 1];
            --size;
            if(size <= currentSize / 3)
                increseordecrease(false);
        }
    }

    public int size(){
        return size;
    }

    public void sort(){
        T temp;
        int done = 0;
        int i;
        for (i = size - 1; i >= 0; i--){
//            System.out.println("i = " + i);
            for (int j = 0; j < i; j++){
                if(vector[j].compareTo(vector[j+1]) > 0){
                    temp = vector[j];
                    vector[j] = vector[j+1];
                    vector[j+1] = temp;
                    done += 1;
                }
            }
            if(done == 0) break;

            done = 0;
        }
    }





}
