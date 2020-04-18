package com.company.Week12.Task1;

import java.util.*;

public class Graph<V> {
    ArrayList<V> vertexList;
    private HashMap<V, ArrayList<V>> adjacencyList;
    private HashMap<V, ArrayList<V>> backwardList;

    private boolean directed;

    public Graph(boolean isDirected){
        vertexList = new ArrayList<>();
        adjacencyList = new HashMap<>();
        backwardList = new HashMap<>();
        directed = isDirected;
    }

    public void addVertex(V obj){
        vertexList.add(obj);
        ArrayList<V> destinations = new ArrayList<>();
        ArrayList<V> destinations2 = new ArrayList<>();
        adjacencyList.put(obj,destinations);
        backwardList.put(obj,destinations2);
    }



    public void addEdge(V from, V to){
        if(adjacencyList.get(from) == null) {
            System.out.println("No such city " + from + " to =" + to );
            return;
        }

        if(adjacencyList.containsKey(from)) {
            adjacencyList.get(from).add(to);
            backwardList.get(to).add(from);
        }
        if(!directed){
            if (adjacencyList.containsKey(to)) {
                adjacencyList.get(to).add(from);
                backwardList.get(from).add(to);
                
            }
        }
    }

    public void removeEdge(V from, V to){
        if(adjacencyList.get(from) == null) {
            System.out.print("No such road " + from + " to =" + to );
            return;
        }

        if(adjacencyList.containsKey(from)) {
            adjacencyList.get(from).remove(to);
            backwardList.get(to).remove(from);
        }
        if(!directed){
            if (adjacencyList.containsKey(to)) {
                adjacencyList.get(to).remove(from);
                backwardList.get(from).remove(to);

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
        ArrayList<V> destinations = adjacencyList.get(obj);
        ArrayList<V> backwards = backwardList.get(obj);

        for(int i = 0; i < backwards.size(); i++){
            System.out.print(backwards.get(i) + " ");
        }
        System.out.println();
    }

    public void advertisement(){
        Stack<V> stack = new Stack<>();
        System.out.println("Popular = " + unseen_adv(vertexList.get(0), stack));
    }

    private V unseen_adv(V obj, Stack<V> stack){
        stack.push(obj);
        System.out.print(obj + ", ");
        ArrayList<V> destinations = adjacencyList.get(obj);
        ArrayList<V> backwards = backwardList.get(obj);


        boolean zashel  = false;
        Vertex temp = new Vertex("  ", 0);


        Vertex obj2 = (Vertex) obj;
        Vertex back = new Vertex(obj2.name, obj2.followers);

        int i = 0;
        while(i < destinations.size()){
            if(stack.search(destinations.get(i)) < 0) {
                Vertex ismore = (Vertex)unseen_adv(destinations.get(i), stack);
                if(ismore.followers > temp.followers){
                    System.out.println("ismore = " + ismore);
                    zashel = true;
                    temp = ismore;
                }
            }
            i++;
        }
        
        i = 0;
        while(i < backwards.size()){
            Vertex ver = (Vertex) backwards.get(i);
            back.followers += ver.followers;
            if(stack.search(backwards.get(i)) < 0) {
                Vertex ismore = (Vertex)unseen_adv(backwards.get(i), stack);
                if(ismore.followers > temp.followers){
                    zashel = true;
                    temp = ismore;
                }
            }
            i++;
        }

        return (!zashel || back.followers > temp.followers) ? ((V)back) : ((V) temp);

    }

    public void DFT(V obj){ //Depth Frist Traversal
        Stack<V> stack = new Stack<>();
        unseen_DFT(obj, stack);
    }

    public void unseen_DFT(V obj, Stack<V> stack){ //Depth Frist Traversal for recursion
        stack.push(obj);
        System.out.print(obj + ", ");
        ArrayList<V> destinations = adjacencyList.get(obj);
        ArrayList<V> backwards = backwardList.get(obj);

        int i = 0;

        while(i < destinations.size()){
            if(stack.search(destinations.get(i)) < 0) {

                unseen_DFT(destinations.get(i), stack);
            }
            i++;
        }

//        while(i < backwards.size()){
//            if(stack.search(backwards.get(i)) < 0) {
//
//                unseen_DFT(backwards.get(i), stack);
//            }
//            i++;
//        }
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
