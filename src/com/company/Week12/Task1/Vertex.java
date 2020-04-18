package com.company.Week12.Task1;

public class Vertex implements Comparable<Vertex> {
    String name;
    int followers = 0;

    public Vertex(String name, int followers) {
        this.name = name;
        this.followers = followers;
    }

    public int compareTo(Vertex acc){
        if(followers > acc.followers)
            return 1;
        else if(followers < acc.followers)
            return -1;
        return 0;
    }

    @Override
    public String toString(){
        return "[" + name + ", " + Integer.toString(followers) + "]";
    }
}
