package com.company.Week13;

public class Short<Vertex> {
    Vertex city;
    Vertex from;
    int shortweight;

    public Short(Vertex city) {
        this.city = city;
        this.from = null;
        this.shortweight = 0;
    }

    @Override
    public String toString(){
        return  city + " " +
                Integer.toString(shortweight) + " " + from ;
    }
}
