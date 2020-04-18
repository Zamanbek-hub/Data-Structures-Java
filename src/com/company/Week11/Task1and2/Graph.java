package com.company.Week11.Task1and2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class Graph<V> {
    private ArrayList<V> vertexList;
    private HashMap<V, ArrayList<V>> adjacencyList;

    private boolean directed;

    public Graph(boolean isDirected){
        vertexList = new ArrayList<>();
        adjacencyList = new HashMap<>();
        directed = isDirected;
    }

    public void addVertex(V obj){
        vertexList.add(obj);
        ArrayList<V> destinations = new ArrayList<>();
        adjacencyList.put(obj,destinations);
    }



    public void addEdge(V from, V to){
        if(adjacencyList.get(from) == null) {
            System.out.println("No such city " + from + " to =" + to );
            return;
        }


        adjacencyList.get(from).add(to);
        if(!directed){
            adjacencyList.get(to).add(from);
        }
    }

    public void removeEdge(V from, V to){
        if(adjacencyList.get(from) == null) {
            System.out.print("No such road " + from + " to =" + to );
            return;
        }

        adjacencyList.get(from).remove(to);
        if(!directed){
            adjacencyList.get(to).remove(from);
        }
    }

    public int findIndex(V obj){
        for(int i = 0; i < vertexList.size(); i++){
            if(vertexList.get(i).equals(obj)){
                return i;
            }
        }
        return 0;
    }

    public void show(V obj){
        ArrayList<V> destinations = adjacencyList.get(obj);

        for(int i = 0; i < destinations.size(); i++){
            System.out.println(destinations.get(i) + " ");
        }
    }

    public boolean haveroadBFT(V obj, V to){ //Breadth First Traversal
        boolean []isVisited = new boolean[vertexList.size()];
        PriorityQueue<V> check = new PriorityQueue<>();
        isVisited[findIndex(obj)] = true;
        check.add(obj);


        while(! check.isEmpty()){

            V del = check.poll();

            ArrayList<V> destinations = adjacencyList.get(del);

            int i = 0;
            while(destinations.size() > i){

                if(!isVisited[findIndex(destinations.get(i))]) {
                    if(destinations.get(i) == to)
                        return true;

                    check.add(destinations.get(i));
                    isVisited[findIndex(destinations.get(i))] = true;
                }

                i++;
            }
        }
        System.out.println("make sure you entered the data correctly");
        return false;
    }

    public void BFT(V obj){ //Breadth First Traversal
        boolean []isVisited = new boolean[vertexList.size()];
        PriorityQueue<V> check = new PriorityQueue<>();
        isVisited[findIndex(obj)] = true;
        check.add(obj);


        while(! check.isEmpty()){

            V del = check.poll();
            System.out.print(del + ", ");

            ArrayList<V> destinations = adjacencyList.get(del);

            int i = 0;
            while(destinations.size() > i){

                if(!isVisited[findIndex(destinations.get(i))]) {
                    check.add(destinations.get(i));
                    isVisited[findIndex(destinations.get(i))] = true;
                }

                i++;
            }
        }


    }
}
