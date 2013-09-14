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
        System.out.println("------------------------------------------");
        printArray(arr);
        System.out.println("k low high  "+ " "+k+" "+ low + " " + high);

        
                
        //pivot = arr[low]
        
        int left=low;int right=high;int pivot=arr[low];
        //System.out.println("l r start while" + left + " " + right);
        while(left<right) {
            
            if(arr[left]>=pivot) {
                //swap left n right
                int tmp=arr[left];
                arr[left]=arr[right];
                arr[right]=tmp;
                right--;
            } else {
                left++;
            }
            //printArray(arr);
            //System.out.println("l r in while" + left + " " + right);
        }
        //decide whether to left-- or right++
        if(arr[left]>=pivot)
            left--;
        else right++;
        
        printArray(arr);
        System.out.println("l r " + left + " " + right);

        //smaller than pivot is arr between low and left inclusive
        //>= pivot is arr between right and high inclusive
        if(k==low || high==k) return arr[k];
        if(k<=left) select(arr,k,low,left);
        if(k>=right) select(arr,k,right,high);
        return arr[k];
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
        int[] arr = {3, 1, 14,14,11,2, 3,2,8,10,11};
        int k =5;
        //System.out.println("Code Result "+select(arr,k,0,arr.length-1));//return the kth elements in array a[k]
        int res =select(arr,k,0,arr.length-1);
        System.out.println("Res" + res);
        System.out.println("SelectKth " + selectKth(arr, k));
        Arrays.sort(arr);
        System.out.println("CorrectAns  " + arr[k]); //k elemenets are smaller , we want k-1 th elements
    }
}
