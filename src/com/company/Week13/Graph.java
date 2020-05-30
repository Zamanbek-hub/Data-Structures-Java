package com.company.Week13;

import com.sun.prism.impl.shape.ShapeRasterizer;

import java.util.*;



public class Graph {
    ArrayList<Vertex> vertexList;
    private HashMap<Vertex, ArrayList<Edge<Vertex>>> adjacencyList;
//    private HashMap<V, ArrayList<V>> backwardList;

    private boolean directed;

    public Graph(boolean isDirected){
        vertexList = new ArrayList<>();
        adjacencyList = new HashMap<>();
        directed = isDirected;
    }

    public void addVertex(Vertex obj){
        vertexList.add(obj);
        ArrayList<Edge<Vertex>> destinations = new ArrayList<>();
        adjacencyList.put(obj,destinations);
    }



    public void addEdge(Vertex from, Vertex to, int weight){
        if(adjacencyList.get(from) == null) {
            System.out.println("No such city " + from + " to =" + to );
            return;
        }

        if(adjacencyList.containsKey(from)) {
            Edge<Vertex> edge = new Edge<>(to,weight);
            adjacencyList.get(from).add(edge);

            if (!directed) {
                if (adjacencyList.containsKey(to)) {
                    edge = new Edge<>(from, weight);
                    adjacencyList.get(to).add(edge);

                }
            }
        }
    }

    public void show(Vertex obj){
        ArrayList<Edge<Vertex>> destinations = adjacencyList.get(obj);

        for(int i = 0; i < destinations.size(); i++){
            System.out.print(destinations.get(i) + " ");
        }
        System.out.println();
    }

    private Vertex findMin(ArrayList<Edge<Vertex>> destinations,Stack<Vertex> stack ){
        int min = Integer.MAX_VALUE, index = -1;
        for(int i = 0; i < destinations.size(); i++) {
            if (min >= destinations.get(i).weight && stack.search(destinations.get(i).des) < 0) {
                min = destinations.get(i).weight;
                index = i;
            }
        }
        System.out.println("Min = " + destinations.get(index).des);
        return destinations.get(index).des;
    }

    private int backToObj(Short src, Short obj, ArrayList<Short<Vertex>> paths){
        int sum = 0;
        if(obj.equals(src))
            return sum;

//        for(int i =0; i < paths.size(); i++){
            for(int j = 0; j < paths.size(); j++)
            if(obj.from.equals(paths.get(j).city)){
                backToObj(src,paths.get(j), paths);
            }

//        }
        return sum += obj.shortweight;
    }

    public void shortPath(Vertex src, Vertex des){

        Stack<Vertex> stack = new Stack<>();

        ArrayList<Short<Vertex>> paths = new ArrayList<>();

        for(int i = 0; i < vertexList.size(); i++)
            paths.add(new Short<>(vertexList.get(i)));

        paths = dijkstra(src, stack, paths, false);

        for(int i = 0; i < paths.size(); i++)
            System.out.println(paths.get(i));

    }

    private ArrayList<Short<Vertex>> dijkstra(Vertex src, Stack<Vertex> stack, ArrayList<Short<Vertex>> paths, boolean second){
        stack.push(src);
        System.out.println("src = " + src);

        ArrayList<Edge<Vertex>> destinations = adjacencyList.get(src);
        boolean zashel = false;

        for(int i = 0; i < destinations.size(); i++){

            if(stack.search(destinations.get(i).des) < 0) {

                for (int j = 0; j < paths.size(); j++) {

                    if (destinations.get(i).des.equals(paths.get(j).city)) {
//                        if (!second) {
                            if (destinations.get(i).weight < paths.get(j).shortweight || paths.get(j).shortweight == 0) {
                                paths.get(j).shortweight = destinations.get(i).weight;
                                paths.get(j).from = src;
                            }
//                        }
//                        else{
//                            if (backToObj(new Short(src),paths.get(j), paths) < paths.get(j).shortweight || paths.get(j).shortweight == 0) {
//                                paths.get(j).shortweight = backToObj(new Short(src),paths.get(j), paths);
//                                paths.get(j).from = src;
//                            }
//                        }

                    }

                }

                zashel = true;

            }


        }

        if(zashel) dijkstra(findMin(destinations, stack), stack, paths,true);

        return paths;
    }










}
