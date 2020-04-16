package com.company.week10;

import java.util.Iterator;
import java.util.Set;

public class main {
    public static void main(String []zbs) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("zzz", 5);
        map.put("abc",7);
        map.put("aba",8);
        map.put("abr",10);
        map.put("abc",12);
        map.put("gfd", 9);
        map.print();
        Set<Integer> iter = map.values();
        map.remove("gfd");
        System.out.println(map.isEmpty());



    }
}
