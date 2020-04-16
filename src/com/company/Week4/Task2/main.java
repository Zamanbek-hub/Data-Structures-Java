package com.company.Week4.Task2;

public class main {
    public static void main(String[] args) {
        DoubleLinkedLIst<Integer> list = new DoubleLinkedLIst<>();
        DoubleLinkedLIst<Integer> list1 = new DoubleLinkedLIst<>();
        list1.add(13,true);
        list1.add(15,false);
        list1.add(14,true);
        list.add(4,true);
        list.add(3,true);
        list.add(5,false);
        list.add(7,false);
        list.add(8,false);
        list.add(2,true);
        list.add(1,true);

        System.out.println("size = " + list.size());
        list.add(6,10);
        list.remove(false);
        list.remove(10);



        list.set(0  ,12);
        System.out.println("size = " + list.size());
        list.add(list1, 1);
        System.out.println("We get = " + list.get(0));
        list.print(true);
    }
}
