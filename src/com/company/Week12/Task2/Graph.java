package com.company.Week12.Task2;

import java.util.*;

public class Graph<V> {
    ArrayList<V> vertexList;
    private HashMap<V, ArrayList<Edge<V>>> adjacencyList;
//    private HashMap<V, ArrayList<V>> backwardList;

    private boolean directed;

    public Graph(boolean isDirected){
        vertexList = new ArrayList<>();
        adjacencyList = new HashMap<>();
        directed = isDirected;
    }

    public void addVertex(V obj){
        vertexList.add(obj);
        ArrayList<Edge<V>> destinations = new ArrayList<>();
        adjacencyList.put(obj,destinations);
    }



    public void addEdge(V from, V to, int weight){
        if(adjacencyList.get(from) == null) {
            System.out.println("No such city " + from + " to =" + to );
            return;
        }

        if(adjacencyList.containsKey(from)) {
            Edge<V> edge = new Edge<>(to,weight);
            adjacencyList.get(from).add(edge);

            if (!directed) {
                if (adjacencyList.containsKey(to)) {
                    edge = new Edge<>(from, weight);
                    adjacencyList.get(to).add(edge);

                }
            }
        }
    }

    public void removeEdge(V from, V to, int weight){
        if(adjacencyList.get(from) == null) {
            System.out.print("No such road " + from + " to =" + to );
            return;
        }

        if(adjacencyList.containsKey(from)) {
            Edge<V> edge = new Edge<>(to, weight);
            adjacencyList.get(from).remove(edge);

            if (!directed) {
                if (adjacencyList.containsKey(to)) {
                    edge = new Edge<>(from, weight);
                    adjacencyList.get(to).remove(edge);

                }
            }
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
        ArrayList<Edge<V>> destinations = adjacencyList.get(obj);

        for(int i = 0; i < destinations.size(); i++){
            System.out.print(destinations.get(i) + " ");
        }
        System.out.println();
    }

    private int sum(ArrayList<Edge<V>> cities){
        int sum = 0;

        for(int i = 0; i < cities.size(); i++){
            Vertex temp = (Vertex) cities.get(i).des;
            sum += temp.sick;
        }

        return sum;
    }
    public void corona_treatment(V obj, int benza){
        Stack<V> stack = new Stack<>();
        stack.push(obj);
        ArrayList<Edge<V>> destinations = treatment(obj, stack, benza);

        int treatsicks = 0, road = 0;

        for(int i = destinations.size() - 1; i >= 0; i--){
            System.out.print(destinations.get(i) + " -> ");
            Vertex ver = (Vertex) destinations.get(i).des;
            treatsicks += ver.sick;
            road += destinations.get(i).weight;
        }


        System.out.println("\nRecovered: " + treatsicks + " sick\ntraveled road: " + road + " km");
    }

    private ArrayList<Edge<V>> treatment(V obj, Stack<V> stack, int benza){
        ArrayList<Edge<V>> destinations = adjacencyList.get(obj);

        int i = 0, count = 0, index = -1;
        boolean zashel = false;
        ArrayList<Edge<V>> list = null, list2;

        while(i < destinations.size()){
            if(benza - destinations.get(i).weight > 0) {
                stack.push(destinations.get(i).des);
                list2 = treatment_find(destinations.get(i), stack, benza - destinations.get(i).weight);
                zashel = true;

                int sum = sum(list2);

                if (count < sum) {
                    count = sum;
                    list = list2;
                }

                stack.clear();
                stack.push(obj);

                i++;
            }
            else{
                index = i;
            }
        }
        if(!zashel) {
            list = new ArrayList<>();
            list.add(destinations.get(index));
        }

        return list;

    }

    private ArrayList<Edge<V>> treatment_find(Edge<V>edge, Stack<V> stack, int benza){
        ArrayList<Edge<V>> destinations = adjacencyList.get(edge.des);
        stack.push(edge.des);

        int i = 0, count = 0;
        boolean zashel = false;
        ArrayList<Edge<V>> list = null, list2;



        while(i < destinations.size()){
            if(benza - destinations.get(i).weight > 0) {
                if (stack.search(destinations.get(i).des) < 0) {
                    zashel = true;
                    list2 = treatment_find(destinations.get(i), stack, benza-destinations.get(i).weight);
                    int sum = sum(list2);
                    if (count < sum) {
                        count = sum;
                        list = list2;
                    }
                }
            }
            i++;
        }

        if(!zashel)
            list = new ArrayList<>();

        list.add(edge);

        return list;
    }

    public void DFT(V obj){ //Depth Frist Traversal
        Stack<V> stack = new Stack<>();
        unseen_DFT(obj, stack);
    }

    public void unseen_DFT(V obj, Stack<V> stack){ //Depth Frist Traversal for recursion
        stack.push(obj);
        System.out.print(obj + ", ");
        ArrayList<Edge<V>> destinations = adjacencyList.get(obj);

        int i = 0;

        while(i < destinations.size()){
            if(stack.search(destinations.get(i).des) < 0) {
                unseen_DFT(destinations.get(i).des, stack);
            }
            i++;
        }

    }

    public void BFT(V obj){ //Breadth First Traversal
        boolean []isVisited = new boolean[vertexList.size()];

        PriorityQueue<V> check = new PriorityQueue<>();

        isVisited[findIndex(obj)] = true;
        check.add(obj);


        while(! check.isEmpty()){

            V del = check.poll();
            System.out.print(del + ", ");

            ArrayList<Edge<V>> destinations = adjacencyList.get(del);

            int i = 0;
            while(destinations.size() > i){

                if(!isVisited[findIndex(destinations.get(i).des)]) {
                    check.add(destinations.get(i).des);
                    isVisited[findIndex(destinations.get(i).des)] = true;
                }

                i++;
            }
        }


    }
}
