package com.company.Week11.Task3;

import java.util.Stack;

public class main {
    public static void main(String[] args) {
//        Stack<Integer> st = new Stack<>();
//        st.push(4);
//        st.push(9);
//        st.push(2);
//        st.push(6);
//        st.push(5);
//        for(int i =0; i < st.size(); i++) {
//            System.out.print(st.get(i) + ", ");
//        }
//        System.out.println();
//        System.out.println(st.search(10));
//        for(int i =0; i < st.size(); i++) {
//            System.out.print(st.get(i) + ", ");
//        }

        Graph<String> insta = new Graph<>(false);

        insta.addVertex("Askar");
        insta.addVertex("Erlan");
        insta.addVertex("Sabina");
        insta.addVertex("Azamat");
        insta.addVertex("Ergali");
        insta.addVertex("Shyngys");
        insta.addVertex("Erik");
        insta.addVertex("Ilyas");
        insta.addVertex("Musa");
        insta.addVertex("Nursultan");
        insta.addVertex("Ivan");

        insta.addEdge("Askar", "Erlan");
        insta.addEdge("Erlan", "Sabina");
        insta.addEdge("Azamat", "Sabina");
        insta.addEdge("Ivan", "Sabina");
        insta.addEdge("Musa", "Sabina");
        insta.addEdge("Erik", "Sabina");
        insta.addEdge("Shyngys", "Sabina");
        insta.addEdge("Azamat", "Ergali");
        insta.addEdge("Azamat", "Musa");
        insta.addEdge("Ergali", "Ivan");
        insta.addEdge("Ergali", "Shyngys");
        insta.addEdge("Musa", "Shyngys");
        insta.addEdge("Ivan", "Shyngys");
        insta.addEdge("Erik", "Musa");
        insta.addEdge("Erik", "Nursultan");
        insta.addEdge("Ilyas", "Musa");
        insta.addEdge("Nursultan", "Ivan");

        insta.show("Erlan");
//        insta.DFT("Ergali");

        insta.podpischicIzdeu("Azamat");
    }
}
