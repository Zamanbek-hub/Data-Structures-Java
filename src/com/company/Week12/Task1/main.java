package com.company.Week12.Task1;

public class main {
    public static void main(String []args) {
        Graph<Vertex> insta = new Graph<>(true);
        Vertex nurbol = new Vertex("nurbol", 420);
        Vertex armani = new Vertex("armani", 250);
        Vertex sabirkin = new Vertex("sabirkin", 1015);
        Vertex zarina = new Vertex("zarina", 500);
        Vertex beks = new Vertex("beks", 344);
        Vertex bake = new Vertex("bake", 235);
        Vertex meirzhan = new Vertex("meirzhan", 985);
        Vertex botagram = new Vertex("botagram", 215);
        Vertex miko = new Vertex("miko", 267);
        Vertex makpalgoi = new Vertex("makpalgoi", 95);
        Vertex berik = new Vertex("berik", 879);
        Vertex saburov = new Vertex("saburov", 670);

        insta.addVertex(nurbol);
        insta.addVertex(armani);
        insta.addVertex(sabirkin);
        insta.addVertex(zarina);
        insta.addVertex(beks);
        insta.addVertex(bake);
        insta.addVertex(meirzhan);
        insta.addVertex(botagram);
        insta.addVertex(miko);
        insta.addVertex(makpalgoi);
        insta.addVertex(berik);
        insta.addVertex(saburov);

        insta.addEdge(nurbol, sabirkin);
//        insta.addEdge(armani,nurbol);
        insta.addEdge(armani, sabirkin);
        insta.addEdge(beks,sabirkin);
        insta.addEdge(zarina,sabirkin);
        insta.addEdge(sabirkin,zarina);
        insta.addEdge(botagram,sabirkin);
        insta.addEdge(beks,zarina);
        insta.addEdge(armani,meirzhan);
        insta.addEdge(botagram, beks);
        insta.addEdge(beks,meirzhan);
        insta.addEdge(botagram,meirzhan);
        insta.addEdge(bake,meirzhan);
        insta.addEdge(berik,meirzhan);
        insta.addEdge(makpalgoi,botagram);
        insta.addEdge(bake,makpalgoi);
        insta.addEdge(makpalgoi,bake);
        insta.addEdge(makpalgoi,saburov);
        insta.addEdge(berik,saburov);
        insta.addEdge(saburov,berik);
        insta.addEdge(miko,berik);
        insta.addEdge(miko,saburov);
//        for(int i = 0;i < insta.vertexList.size(); i ++)
//            System.out.println(i + ") " + insta.vertexList.get(i));
        insta.advertisement();
//        insta.DFT(botagram);

//        insta.advertisement(botagram);

    }

}
