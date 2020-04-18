package com.company.Week12.Task2;

public class Edge<V> {
//    V src;
    V des;
    int weight;

    public Edge( V des, int weight) {
//        this.src = src;
        this.des = des;
        this.weight = weight;
    }

    @Override
    public String toString(){
        return "[" + des + " " +Integer.toString(weight) + " km]";
    }
}
