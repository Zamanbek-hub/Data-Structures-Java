package com.company.Week11.Task3;

import java.util.*;

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

        if(adjacencyList.containsKey(from)) {
            adjacencyList.get(from).add(to);
        }
        if(!directed){
            if (adjacencyList.containsKey(to)) {
                adjacencyList.get(to).add(from);
            }
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
            System.out.print(destinations.get(i) + " ");
        }
        System.out.println();
    }

    public void podpischicIzdeu(V obj){//Find Friends
        Stack<V> stack = new Stack<>();
        HashMap<V, Integer> byCount = new HashMap<V, Integer>();

        ArrayList<V> destinations = adjacencyList.get(obj);
        int i = 0;

        while(destinations.size() > i){
            if(stack.search(destinations.get(i)) < 0)
                stack.push(destinations.get(i));
            i++;
        }
        System.out.println(stack);
        System.out.println(findFriends(obj, stack, byCount, true));

    }

    private HashMap<V, Integer> findFriends(V obj, Stack<V> stack,HashMap<V, Integer> byCount, boolean instack){ //Find Friends for recursion
        stack.push(obj);

        ArrayList<V> destinations = adjacencyList.get(obj);

        int i = 0;
        while(i < destinations.size()){
            if(instack) {
                findFriends(destinations.get(i), stack, byCount, false);
            }
            else{
                if (stack.search(destinations.get(i)) == -1) {
                    int j = 0;
                    int size = adjacencyList.get(destinations.get(i)).size();
                    while(j < adjacencyList.get(destinations.get(i)).size()){
                        if(stack.search(adjacencyList.get(destinations.get(i)).get(j)) > 0)
                            size--;
                        j++;
                    }
                    byCount.put(destinations.get(i),size);
                }
            }
            i++;
        }
        return byCount;
    }

    public void DFT(V obj){ //Depth Frist Traversal
        Stack<V> stack = new Stack<>();
        unseen_DFT(obj, stack);
    }

    public void unseen_DFT(V obj, Stack<V> stack){ //Depth Frist Traversal for recursion
        stack.push(obj);
        System.out.print(obj + ", ");
        ArrayList<V> destinations = adjacencyList.get(obj);

        int i = 0;



        while(i < destinations.size()){
            if(stack.search(destinations.get(i)) < 0) {

                unseen_DFT(destinations.get(i), stack);
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
