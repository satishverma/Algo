/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algods.Arrays;

import java.util.Arrays;

/**
 *
 * @author sverma
 */
public class Selection {

    private static int select(int[] arr, int k, int low, int high) {
        //PIVOT is first element
        System.out.println("low high " + low + " " + high);

        if (low == high) {
            return arr[low];
        }
        if (high < low) {
            return -1;
        }
        if ((high - low) == 1) {
            return arr[low];
        }

        int[] aux = new int[high - low];
        int currmin = low;
        int currmax = high - 1;
        System.out.println("currmin currmax " + currmin + " " + currmax);


        //hign n low are included
        for (int i = low + 1; i < high; i++) {
            //System.out.println(i);
            if (arr[i] < arr[low]) {
                aux[currmin++] = arr[i];
            }
            if (arr[i] > arr[low]) {
                aux[currmax--] = arr[i];
            }

        }
        for (int i = currmin; i <= currmax; i++) {
            aux[i] = arr[low];
        }


        printArray(aux);
        System.out.println("currmin " + currmin);
        System.out.println("currmax " + currmax);

        //0...curmin-1 is left , currmax+1...high is right and currmin to currmax is kth values all INCLUSIVE RANGES 


        if (currmin <= k && k <= currmax) {
            System.out.println("Done");
            return arr[low];
        }

        if (k < (currmin)) {
            select(aux, k, low, currmin);
        }
        if (k > (currmax)) {
            select(aux, k - currmax - 1, currmax + 1, high);
        }



        return 0;
    }

    public static int selectKth(int[] arr, int k) {
        if (arr == null || arr.length <= k) {
            throw new Error();
        }

        int from = 0, to = arr.length - 1;

        // if from == to we reached the kth element
        while (from < to) {
            int r = from, w = to;
            int mid = arr[(r + w) / 2];

            // stop if the reader and writer meets
            while (r < w) {

                if (arr[r] >= mid) { // put the large values at the end
                    int tmp = arr[w];
                    arr[w] = arr[r];
                    arr[r] = tmp;
                    w--;
                } else { // the value is smaller than the pivot, skip
                    r++;
                }
            }

            // if we stepped up (r++) we need to step one down
            if (arr[r] > mid) {
                r--;
            }

            // the r pointer is on the end of the first k elements
            if (k <= r) {
                to = r;
            } else {
                from = r + 1;
            }
        }

        return arr[k];
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 3, 3, 1, 4, 6, 9, 5, 4};
        int k = 10;
        // System.out.println("Code Result "+select(arr,k,0,arr.length));//return the kth elements in array a[k]


        System.out.println("SelectKth " + selectKth(arr, k));
        Arrays.sort(arr);
        System.out.println("CorrectAns  " + arr[k]); //k elemenets are smaller , we want k-1 th elements
    }
}
