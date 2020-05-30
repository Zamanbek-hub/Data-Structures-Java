package com.company.Week13;



public class main {
    public static void main(String []args){
        Graph corona = new Graph(false);

        Vertex a = new Vertex("A", 76);
        Vertex b = new Vertex("B", 55);
        Vertex c = new Vertex("C", 87);
        Vertex d = new Vertex("D", 105);
        Vertex e = new Vertex("E", 45);


        corona.addVertex(a);
        corona.addVertex(b);
        corona.addVertex(c);
        corona.addVertex(d);
        corona.addVertex(e);


        corona.addEdge(a, b, 6);
        corona.addEdge(a, d, 1);
//        corona.addEdge(d, b, 2);
        corona.addEdge(d, e, 2);
        corona.addEdge(b, c, 5);
        corona.addEdge(b, e, 4);
        corona.addEdge(c, e, 5);

//        corona.DFT(almaty);
//        System.out.println();
//        corona.show(almaty);
//        corona.corona_treatment(shymkent, 15);

        corona.shortPath(a,e);
        corona.show(a);
//        corona.DFT(almaty);
    }
}
