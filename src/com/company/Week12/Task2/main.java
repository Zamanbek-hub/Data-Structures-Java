package com.company.Week12.Task2;

public class main {
    public static void main(String []kek){
        Graph<Vertex> corona = new Graph<>(false);

        Vertex aktau = new Vertex("Aktau", 76);
        Vertex atyrau = new Vertex("Atyrau", 55);
        Vertex aktobe = new Vertex("Aktobe", 87);
        Vertex qyzylorda = new Vertex("Qyzylorda", 105);
        Vertex turkistan = new Vertex("Turkistan", 45);
        Vertex shymkent = new Vertex("Shymkent", 50);
        Vertex karagandy = new Vertex("Karagandy", 98);
        Vertex nursultan = new Vertex("Nursultan", 220);
        Vertex shu = new Vertex("Shu", 20);
        Vertex almaty = new Vertex("Almaty", 120);
        Vertex semey = new Vertex("Semey", 35);
        Vertex oskemen = new Vertex("Oskemen", 68);

        corona.addVertex(aktau);
        corona.addVertex(atyrau);
        corona.addVertex(aktobe);
        corona.addVertex(qyzylorda);
        corona.addVertex(turkistan);
        corona.addVertex(shymkent);
        corona.addVertex(karagandy);
        corona.addVertex(nursultan);
        corona.addVertex(shu);
        corona.addVertex(almaty);
        corona.addVertex(semey);
        corona.addVertex(oskemen);

        corona.addEdge(aktau, atyrau, 6);
        corona.addEdge(aktau, qyzylorda, 6);
        corona.addEdge(atyrau, qyzylorda, 8);
        corona.addEdge(atyrau, aktobe, 4);
        corona.addEdge(aktobe, qyzylorda, 14);
        corona.addEdge(qyzylorda, turkistan, 3);
        corona.addEdge(turkistan, shymkent, 5);
        corona.addEdge(shymkent, karagandy, 13);
        corona.addEdge(qyzylorda, karagandy, 12);
        corona.addEdge(aktobe, nursultan, 9);
        corona.addEdge(nursultan, karagandy, 4);
        corona.addEdge(shymkent, almaty, 10);
        corona.addEdge(almaty,karagandy, 16);
        corona.addEdge(almaty, shu, 4);
        corona.addEdge(almaty, oskemen, 19);
        corona.addEdge(oskemen, karagandy, 16);
        corona.addEdge(oskemen, semey, 6);
        corona.addEdge(almaty,semey, 17);
        corona.addEdge(semey,nursultan, 6);

//        corona.DFT(almaty);
//        System.out.println();
//        corona.show(almaty);
        corona.corona_treatment(shymkent, 15);
    }
}
