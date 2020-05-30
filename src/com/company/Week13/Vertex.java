package com.company.Week13;

public class Vertex implements Comparable<Vertex>{
    String city;
    int sick;

    public Vertex(String city, int sick) {
        this.city = city;
        this.sick = sick;
    }

    @Override
    public String toString(){
        return  city ;
    }

    @Override
    public int compareTo(Vertex V){
        if(city.equals(V.city)) {
            System.out.println("(" + city + ") " + " (" + V.city + ")");
            return 1;
        }
        else
        return -1;
    }
}