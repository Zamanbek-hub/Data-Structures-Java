package com.company.Week3.Task1;

import java.util.LinkedList;

public class main {
    public static void main(String[] args) {
        Vector<Student> studentVector = new Vector<>();
        studentVector.add(new Student("aaa", 19, 3.3));
        studentVector.add(new Student("bbb", 18, 3.1));
        studentVector.add(new Student("ccc", 17, 2.2));
        studentVector.add(new Student("jjj", 17, 2.0));
        studentVector.add(new Student("jjj", 17, 2.0));
        studentVector.add(new Student("mmm", 17, 4.0));
        studentVector.remove(0);
        System.out.println(studentVector.get(0) + "---");
        System.out.println(studentVector.size());
        studentVector.sort();
        System.out.println(studentVector);
        for(int i = 0; i < studentVector.size(); i++)
            System.out.println(studentVector.get(i));
        System.out.println(studentVector.size());

        Vector<Employee> employeeVector = new Vector<>();
        employeeVector.add(new Employee("aaa", 19));
        employeeVector.add(new Employee("bbb", 18));
        employeeVector.add(new Employee("ccc", 17));
        employeeVector.add(new Employee("jjj", 17));
        employeeVector.add(new Employee("jjj", 17));
        employeeVector.add(new Employee("mmm", 17));
        employeeVector.add(new Employee("mmm", 17));
        employeeVector.add(new Employee("mmm", 17));
        employeeVector.add(new Employee("mmm", 17));
        employeeVector.add(new Employee("mmm", 17));

//
        System.out.println(employeeVector.get(0) + "---");
        System.out.println(employeeVector.size());
        employeeVector.sort();
        System.out.println(employeeVector);
        for(int i = 0; i < employeeVector.size(); i++)
            System.out.println(employeeVector.get(i));
        System.out.println(employeeVector.size());
        employeeVector.remove(0);
        employeeVector.remove(0);

        for(int i = 0; i < employeeVector.size(); i++)
            System.out.println(employeeVector.get(i));


    }
}
