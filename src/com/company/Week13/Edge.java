package com.company.Week13;

public class Edge<Vertex> {
    //    V src;
    Vertex des;
    int weight;

    public Edge( Vertex des, int weight) {
//        this.src = src;
        this.des = des;
        this.weight = weight;
    }

    @Override
    public String toString(){
        return "[" + des + " " +Integer.toString(weight) + " km]";
    }
}
