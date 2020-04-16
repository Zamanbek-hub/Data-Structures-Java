package com.company.Week3.Task1;

public class Student implements Comparable<Student> {
    private String name;
    private int age;
    private double gpa;

    public Student() {
    }

    public Student(String name, int age, double gpa) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    @Override
    public String toString(){
        return "Student[" +
                "name='" + name + '\'' +
                ", age=" + age + ", GPA= " + gpa + "]";
    }

    @Override
    public int compareTo(Student S){
        System.out.println("We are in Student");
        if(this.gpa > S.gpa)
            return 1;
        else if(this.gpa < S.gpa)
            return -1;
        return 0;
    }
}
