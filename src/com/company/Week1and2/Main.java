package com.company.Week1and2;

import com.sun.deploy.nativesandbox.NativeSandboxBroker;
import com.sun.scenario.effect.Merge;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;

public class Main {
    LinkedList<String> g = new LinkedList<>();
    public static int[] Buuble(int [] arr){
        int temp;
        int done = 0;
        int i;
        for (i = arr.length - 1; i >= 0; i--){
            for (int j = 0; j < i; j++){
                if(arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    done += 1;
                }
            }
            if(done == 0) break;

            done = 0;
        }
        return arr;
    }

    public static int[] Insert(int []arr){
        int temp;
        for(int i = arr.length - 1; i >= 0; i--){
            for(int j = i; j < arr.length - 1; j ++){
                if(arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            System.out.print(arr.length - i + ") ");
            for(int z = 0; z < arr.length; z ++)
                System.out.print(arr[z] + " ");
            System.out.println();
        }
        return arr;
    }

    public static int[] Selection(int []arr, int pos){
        int len = arr.length;
        if(pos == len)
            return arr;
        int temp;
        int min = pos;
        System.out.println("Position: " + pos);
        for(int i = pos; i < arr.length; i++){
            if(arr[i] < arr[min]){
                min = i;
            }
        }
        System.out.println("Min index: " + min);
        temp = arr[pos];
        arr[pos] = arr[min];
        arr[min] = temp;
        for(int i = 0; i < arr.length; i ++)
            System.out.print(arr[i] + " ");
        System.out.println();
        return Selection(arr, pos+1);
    }
    //O((n log n)^2)
    public static int[] Shell(int []arr){
        int len = arr.length;
        int gap = arr.length / 2;
        int temp, current;
        for(int i = gap; i > 0; i /= 2){
            for(int j = i; j < len; j++){
                for(int z = j; z - i >= 0; z -= i){
                    if( arr[z - i] > arr[z]) {
                        temp = arr[z];
                        arr[z] = arr[z - i];
                        arr[z - i] = temp;
                    }
                    else break;
                }
//                for(int z = 0; z < arr.length; z++)
//                    System.out.print(arr[z] + " ");
//                System.out.println();
            }
            //            System.out.println();
        }
        return arr;
    }

    public static int[] Count(int [] arr, int len, int compsn){
        int []order = new int[len];
        int []result= new int[len  + 1];

        for(int i =0; i < len; i++) {
            order[(arr[i] / compsn) % 10] += 1;
        }

        for(int i = 1; i < len; i++){
            order[i] += order[i - 1];
        }

        for(int i =len - 1; i >= 0; i--){

            result[order[(arr[i] / compsn)  % 10 ]] = arr[i];
            order[(arr[i] / compsn)  % 10 ] -= 1;

        }

        for(int i = 1; i < len + 1; i++)
            arr[i - 1] = result[i];
        return arr;

    }
    //O(nk)
    public static int [] Radix(int [] arr){
        int len = arr.length;
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }

        for(int compsn = 1; max/compsn > 0; compsn *= 10){
            arr = Count(arr,len, compsn);
//            for(int i = 0; i < arr.length; i ++)
//                System.out.print(arr[i] + " ");
//            System.out.println();
        }
        return arr;
    }

    public static String[] Count2(String [] arr2, int len, int compsn){
        int []order = new int[27];
        String []result= new String[27];
        int temp = 0;
        for(int i =0; i < len; i++) {
            temp = (int) arr2[i].charAt(compsn) - 96;
            if (temp != -48) {
                if(temp != -64) {
                    System.out.println((int) arr2[i].charAt(compsn) - 96);
                    order[(int) arr2[i].charAt(compsn) - 96] += 1;
                }
                else  order[0] += 1;
            }
            else  order[0] += 1;

        }

        System.out.println("order[26] = " + order[26]);

        for(int i = 1; i < 27; i++){
            order[i] += order[i - 1];
        }

        for(int i =0; i < order.length; i++){
            System.out.println("order [" + i + "] = " + order[i]);
        }

        for(int i =len - 1; i >= 0; i--){
            temp = (int) arr2[i].charAt(compsn) - 96;
            if(temp != -48) {
                if(temp != -64) {
                    System.out.println((int) arr2[i].charAt(compsn) - 96);
                    result[order[(int) arr2[i].charAt(compsn) - 96]] = arr2[i];
                    order[(int) arr2[i].charAt(compsn) - 96] -= 1;
                }
                else {
                    result[order[0]] = arr2[i];
                    order[0] -= 1;
                }
            }
            else {
                result[order[0]] = arr2[i];
                order[0] -= 1;
            }
        }

        for (int i =0; i < result.length; i++){
            System.out.println("result = " + result[i]);

        }

        for(int i = 1; i < len + 1; i++)
            arr2[i - 1] = result[i];
        return arr2;

    }

    public static String [] Radix2(String [] arr2){
        int len = arr2.length;
        int max = arr2[0].length();
        String arr3[] = arr2.clone();
        for (int i = 0; i < arr3.length; i++) {
            arr3[i] = arr3[i].toLowerCase();
            if (arr3[i].length() > max)
                max = arr3[i].length();
        }

        int dif;
        String help = "0";
        for(int i = 0; i < arr3.length; i++){
            dif = max - arr3[i].length();
            arr3[i] = new String(new char[dif]).replace("\0", help) + arr3[i];
        }

        for(int i =0; i < arr3.length; i++){
            System.out.println(arr3[i]);
        }

        System.out.println("Max = " + max);
        int time =1;
        for(int compsn = max - 1; compsn >= 0; compsn -= 1){
            arr3 = Count2(arr3, len, compsn);
            System.out.println(time + " Zahod");
            time++;
            for(int i =0; i < arr3.length; i++){
                System.out.println(arr3[i]);

            }
        }

        for(int i =0; i < arr3.length; i++){
            arr3[i] = arr3[i].replace("0", " ");
            arr3[i] = arr3[i].trim();
            arr3[i] = arr3[i].substring(0, 1).toUpperCase() + arr3[i].substring(1,arr3[i].length());
        }
        


        System.out.println("Answer: ");
        for(int i =0; i < arr3.length; i++){
            System.out.println(arr3[i]);

        }
        return arr3;
    }
    //O(n log(n))
    public static int[] HeapSort(int [] arr){
        int len = arr.length;
        for(int i = len/2 - 1; i >= 0; i--){
            Heapify(arr,len,i);
        }

        for(int i = len - 1; i >= 1; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            Heapify(arr,i,0);
        }
        return arr;
    }

    public static void Heapify(int [] arr, int len, int i){
        int current = i;
        int left = i * 2 + 1;
        int right = i * 2 + 2;

        if( left < len && arr[left] > arr[current]){
            current = left;
        }

        if( right < len && arr[right] > arr[current]){
            current = right;
        }

        if(current != i){
            int temp = arr[i];
            arr[i] = arr[current];
            arr[current] = temp;

            Heapify(arr, len, current);
        }

    }

    public static int Pivot(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = (low - 1);

//        int temp = arr[high];
//        arr[high] = pivot;
//        arr[(high + 1)/2 - 1] = temp;
        int temp;
        for(int j = low; j < high; j++){
            if(arr[j] < pivot){
                i++;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
    //O(n^2)
    public static int[] Quick(int[] arr, int low, int high){
        if(low < high){
            int pivot = Pivot(arr, low, high);
            Quick(arr,low,pivot-1);
            Quick(arr,pivot+1, high);
        }
        return arr;
    }

    public static void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];

        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    public static int[] Mergesort(int arr[], int l, int r)
    {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;

            // Sort first and second halves
            Mergesort(arr, l, m);
            Mergesort(arr , m+1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
        return arr;
    }
    
    public static void main(String[] args) {
//	    int[] arr = new int[10];
	    String[] strings = {"Alisher","Akzhol", "Bota","Zhalgas","Wh te", "AliKhan", "Diana", "Talshyn", "Zhalga", "Zamanbek", "Nurdan", "Asem", "Tima", "Sultan", "Esimkhan", "Cheese", "Pepperoni", "Black Olives"};


//	    for(int i = 0; i < 10; i++)
//	        arr[i] = (int)(Math.random() * (100 - 1) + 1) + 1;
//
//        for(int i = 0; i < arr.length; i ++)
//            System.out.print(arr[i] + " ");
//        System.out.println();

//        arr = Buuble(arr);
//	    arr = Insert(arr);
//	    arr = Selection(arr, 0);
//        arr = Shell(arr);
//        arr = Radix(arr);
//        strings = Radix2(strings);
//        arr = HeapSort(arr);
//        arr = Quick(arr,0,arr.length - 1);
//        arr = Mergesort(arr,0, arr.length-1 );


//        System.out.println("Answer: ");
//	    for(int i = 0; i < arr.length; i ++)
//            System.out.print(arr[i] + " ");
//
//	    int num = 88;
//	    num = num / 100;
//        System.out.println("\n" + num);

//        for(int i:arr)
//            System.out.print(arr[i] + " ");

        /*******************************************************************************************************************************************
         * ********************************************************************************************************************
         * ***************************************************************************************************************
         */

        // for task 3
        int counter = 0;
        for(int z = 0; z < 3; z++) {
            counter += 1;
            int[] arr = new int[15000 * counter];
            for(int i = 0; i < 15000 * counter; i++)
                arr[i] = (int)(Math.random() * (100000 - 1) + 1) + 1;

            int[] arr1 = arr.clone();
            String[] sortes = {"| Bubble", "| Quick", "| Merge", "| Heap", "| Radix"};
            long[] times = new long[5];
            int[] spaces = new int[5];
//            System.out.println();
//            System.out.println("ff");
//            System.out.println("Answer before bubble: ");
//            for (int i = 0; i < arr1.length; i++)
//                System.out.print(arr1[i] + " ");

            long startTime = System.currentTimeMillis();
            Buuble(arr1);
            long endTime = System.currentTimeMillis();
            times[0] = endTime - startTime;


            arr1 = arr.clone();

//            System.out.println("Answer before quick: ");
//            for (int i = 0; i < arr1.length; i++)
//                System.out.print(arr1[i] + " ");

            startTime = System.currentTimeMillis();
            Quick(arr1, 0, arr.length - 1);
            endTime = System.currentTimeMillis();
            times[1] = endTime - startTime;

            arr1 = arr.clone();
            startTime = System.currentTimeMillis();
            Mergesort(arr1, 0, arr.length - 1);
            endTime = System.currentTimeMillis();
            times[2] = endTime - startTime;


            arr1 = arr.clone();

//            System.out.println("Answer before heap: ");
//            for (int i = 0; i < arr1.length; i++)
//                System.out.print(arr1[i] + " ");

            startTime = System.currentTimeMillis();
            HeapSort(arr1);
            endTime = System.currentTimeMillis();
            times[3] = endTime - startTime;


            arr1 = arr.clone();

//            System.out.println("Answer before radix: ");
//            for (int i = 0; i < arr1.length; i++)
//                System.out.print(arr1[i] + " ");

            startTime = System.currentTimeMillis();
            Radix(arr1);
            endTime = System.currentTimeMillis();
            times[4] = endTime - startTime;
            if(counter == 1) {
                System.out.println();
                System.out.print("Array size:    ");
                for (int i = 0; i < sortes.length; i++) {
                    System.out.print(sortes[i] + "       ");
                    spaces[i] = sortes[i].length() - 1;
                }
            }
            System.out.println();
            System.out.print(15000 * counter + ":          ");
            for (int i = 0; i < times.length; i++) {
                spaces[i] = 1 + (spaces[i] - Long.toString(times[i]).length());
//            System.out.println("Long size = " + Long.toString(times[i]).length() + "\n Spaces = " + spaces[i]);
                System.out.print(times[i] + new String(new char[spaces[i]]).replace("\0", " ") + "       ");
            }
        }

    }
}
