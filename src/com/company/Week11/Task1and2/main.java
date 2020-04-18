package com.company.Week11.Task1and2;

import com.company.Week11.Task1and2.Graph;

public class main {

    public static void main(String[] args) {
        Graph<String> citymap = new Graph<>(true);
//        Task 1


        citymap.addVertex("Astana");
        citymap.addVertex("Aktau");
        citymap.addVertex("Almaty");
        citymap.addVertex("Semey");
        citymap.addVertex("Shymkent");
        citymap.addVertex("Aktobe");
        citymap.addVertex("Aktau");
        citymap.addVertex("Taldyk");
        citymap.addVertex("Atyrau");

        citymap.addEdge("Taldyk", "Astana");
        citymap.addEdge("Semey", "Almaty");
        citymap.addEdge("Almaty", "Taldyk");
        citymap.addEdge("Almaty", "Shymkent");
        citymap.addEdge("Astana", "Shymkent");
        citymap.addEdge("Astana", "Aktau");
        citymap.addEdge("Astana", "Aktobe");
        citymap.addEdge("Atyrau", "Aktobe");
        citymap.addEdge("Atyrau", "Aktau");
        citymap.addEdge("Aktobe", "Aktau");

//        citymap.BFT("A");
        citymap.removeEdge("Astana", "Aktau");
        citymap.removeEdge("Astana", "Aktobe");

        System.out.println(citymap.haveroadBFT("Taldyk", "Aktau"));
//        citymap.show("D");

//        ***************************
//        TASK 2
//        citymap.addEdge("Almaty", "Taldyk");
//        citymap.addEdge("Taldyk", "Semey");
//        citymap.addEdge("Semey", "Almaty");
//        citymap.addEdge("Almaty", "Shymkent");
//        citymap.addEdge("Almaty", "Aktobe");
//        citymap.addEdge("Astana", "Shymkent");
//        citymap.addEdge("Shymkent", "Astana");
//        citymap.addEdge("Astana", "Semey");
//        citymap.addEdge("Aktobe", "Aktau");
//        citymap.addEdge("Aktobe", "Astana");
//        citymap.addEdge("Aktobe", "Atyrau");
//        citymap.addEdge("Astana", "Aktau");

//        System.out.println(citymap.haveroadBFT("Semey", "Aktau"));




    }



}
