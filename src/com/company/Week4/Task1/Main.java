package com.company.Week4.Task1;


import com.company.Week3.Task1.Student;
import com.company.Week4.Task1.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Student> List = new LinkedList<>();
        LinkedList<Student> List1 = new LinkedList<>();
        Student s = new Student("Asel", 19, 3.3);
        List.add(new Student("bota", 19, 3.3));
//        List.add(new Student("Sultan", 19, 3.3));
        List.add(new Student("Akzhol", 19, 3.3));
        List.add(new Student("Asel", 19, 3.3));
        List.add(new Student("Masha", 19, 3.3));

//        System.out.println(List);
//        List.remove(new Student("Asel", 19, 3.3));
//        System.out.println(List);
//        List.add(3,new Student("Sultan", 19, 3.3));
//        List.add(List1);
//        List.addFirst(new Student("Sultan", 19, 3.3));
//        List1 = List.clone();
        List.set(0,new Student("Sultan", 19, 3.3));
        List.print(true);


//        LinkedList<Integer> list = new LinkedList<>();
//        LinkedList<Integer> list1 = new LinkedList<>();
//        list1.add(8);
//        list1.add(12);
//        list1.add(10);
//
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(3);
//        list.add(4);
//        list.remove(4);
//        list.set(0,5);
//        System.out.println("A");
//        list.add(list1);
//        list1 = list.clone();
//        System.out.println("" +  list.get(15));
//        System.out.println("" +  list.getFirst());
//        System.out.println("" +  list.getLast());
//
//        System.out.println("index: " + list.indexOf(3));
//        System.out.println("size = " + list.size());
//        list.remove(4);
//        System.out.println("size = " + list.size());
//        System.out.println(list);
//        list.print(false);

    }
}
