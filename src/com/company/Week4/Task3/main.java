package com.company.Week4.Task3;

import com.company.Week3.Task1.Employee;
import com.company.Week3.Task1.Student;
import com.company.Week3.Task2.Wallet;

import java.util.ListIterator;

public class main {
    public static void main(String[] args){

        LinkedList<Employee> employeeVector = new LinkedList<>();
        employeeVector.addSorted(new Employee("aaa", 19));
        employeeVector.addSorted(new Employee("bbb", 25));
        employeeVector.addSorted(new Employee("ccc", 21));
        employeeVector.addSorted(new Employee("jjj", 12));
        employeeVector.addSorted(new Employee("jjj", 10));
        employeeVector.addSorted(new Employee("mmm", 32));
//        LinkedList<String> list = new LinkedList<>();
//        list.addSorted("Nurdan");
//        list.addSorted("Akzhol");
//        list.addSorted("Zamanbek");
//        list.addSorted("Talshyn");
//        list.addSorted("Bota");
//
//
//        list.print(true);
//       List.sort();
//       list.print(true);

        employeeVector.print(true);
        java.util.LinkedList<Integer> list = new java.util.LinkedList<>();
        list.add(0);
        list.add(10);
        list.add(12);
        list.add(15);
        ListIterator iter = list.listIterator(2);
    }
}
