package com.company.Week12.Task2;

public class Vertex {
    String city;
    int sick;

    public Vertex(String city, int sick) {
        this.city = city;
        this.sick = sick;
    }

    @Override
    public String toString(){
        return "[" + city + ", " + Integer.toString(sick) + " sick]";
    }
}