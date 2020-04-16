package com.company.Week1and2;

import java.util.Arrays;
class newClass{


    public static void buble_sort(int[] a) {

        int n = a.length;
        boolean stop;


        for(int i = 0; i < n; i++){
            stop = false;
            for(int j = 0; j < n - i - 1; j++){
                if(a[j] > a [j + 1]){
                    int temp = a[j];
                    a[j] = a [j + 1];
                    a[j + 1] = temp;
                    stop = true;
                }
            }
            if(!stop){
                break;
            }
//            for(int z = 0; z < a.length; z++){
//                System.out.print(a[z]+ " ");
//            }
//
//            System.out.println("");
        }

    }


    public static int Shell_sort(int arr[])
    {
        int n = arr.length;


        // Start with a big gap, then reduce the gap
        for (int gap = n/2; gap > 0; gap /= 2)
        {

            for (int i = gap; i < n; i += 1)
            {

                int temp = arr[i];


                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
                    arr[j] = arr[j - gap];


                // location
                arr[j] = temp;
            }
        }
        return 0;
    }


    public static int Radixmax (int []arr, int n){
        int max = arr[0];
        for(int i = 1; i < n ; i++){
            if(arr[i] > max)
                max = arr[i];
            return max;
        }
        return 0;

    }

    public  static void count_Sort(int arr[], int n, int x)
    {
        int output[] = new int[n];
        int count[] = new int[10];
        Arrays.fill(count,0);
        // Store count
        for(int i = 0; i < n; i++)
            count[ (arr[i] / x) % 10 ]++;
        // Change count[i] so that count[i] now contains
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];
        //output[]array
        for (int i = n - 1; i >= 0; i--)
        {
            output[count[ (arr[i] / x) %10 ] - 1] = arr[i];
            count[ (arr[i] / x) % 10 ]--;

        }
        for (int i = 0; i < n; i++)
            arr[i] = output[i];
    }


    public static void Radixsort(int arr[], int n){
        int m = Radixmax(arr, n);
        for (int x = 1; m / x > 0; x *= 10)
            count_Sort(arr, n, x);
    }

    public static void Heap_sort(int[] a,int n, int index) {
        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < n && a[left] > a[largest])
            largest = left;
        if (right < n && a[right] > a[largest])
            largest = right;
        //if largest is not root
        if(largest != index){
            // swap
            int t = a[index];
            a[index] = a[largest];
            a[largest] = t;

            Heap_sort(a, n, largest);
        }

    }

    public void Heapsort(int[] a){
        int n = a.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            Heap_sort(a, n, i);

        for(int i = n - 1; i >= 0; i--){
            // перемещаем текущий корень в конец
            int t = a[0];
            a[0] = a[i];
            a[i] = t;

            Heap_sort(a, i , 0);
        }
    }


    public static int Divide_conquer(int[] arr,int low, int high ) {
        int poloshenie = arr[high];
        int s = (low - 1);//smaller element
        for (int i = low; i < high; i++){
            if (arr[i] < poloshenie){
                s++;

                int t = arr[s];
                arr[s] = arr[i];
                arr[i] = t;
            }
        }
        int t = arr[s+1];
        arr[s+1] = arr[high];
        arr[high] = t;

        return s + 1;

    }



    public void Quicksort(int[] arr, int low, int high){
        if(low < high){
            int p = Divide_conquer(arr, low, high);
            //recursively sort
            Quicksort(arr, low, p - 1);//bef
            Quicksort(arr, p + 1, high); //after
        }

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
}



public class sortt {

    public static Long Time(int [] arr1,int which, newClass nc){

        long startTime = System.currentTimeMillis();
        if(which == 1)
            nc.buble_sort(arr1);
        else if(which == 2)
            nc.Quicksort(arr1, 0 , arr1.length - 1);
        else if(which == 3)
            nc.Mergesort(arr1,0, arr1.length-1);
        else if(which == 4)
            nc.Heapsort(arr1);
        else if(which == 5)
            nc.Radixsort(arr1,arr1.length-1);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
    public static void main(String[] args) {
        newClass nc = new newClass();
        int[] array = {10, 8, 99, 7, 1, 5, 88, 9};
        System.out.println(Arrays.toString(array));

//        nc.buble_sort(array);
//        nc.Shell_sort(array);
//          nc.Radixsort(array,array.length - 1);
//        nc.Heapsort(array);
//        nc.Quicksort(array,0,array.length-1);

//        for(int i = 0; i < array.length; i++){
//            System.out.print(array[i] + " ");
//        }


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



            times[0] = Time(arr1,1,nc);


            arr1 = arr.clone();


            times[1] = Time(arr1,2,nc);

            arr1 = arr.clone();

            times[2] = Time(arr1,3,nc);


            arr1 = arr.clone();



            times[3] = Time(arr1,4,nc);


            arr1 = arr.clone();


            times[4] = Time(arr1,5,nc);
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
                System.out.print(times[i] + new String(new char[spaces[i]]).replace("\0", " ") + "       ");
            }
        }


    }
}
