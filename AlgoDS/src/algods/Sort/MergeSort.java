/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algods.Sort;

import java.util.*;

public class MergeSort {

    public static void main(String[] args) {
        final int N=16;
        final int max=100;
        int[] arr = new int[N];
        int[] res =  new int[N];
        for (int i =0;i<N;i++) {
            arr[i]= (new Random()).nextInt(max);
            res[i]=arr[i];
        }
          Arrays.sort(res);
        
        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }
        mergeSort(arr, 0, arr.length - 1);
        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < N; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }
    
    private static void mergeSort(int[] arr,int low,int high) {
        System.out.println("low high "+low+" "+high);
        if(high<=low)return;
        int mid = (low+high)/2;
        
        mergeSort(arr,low,mid);
        mergeSort(arr,mid+1,high);
        
        //merge op happens for low to high 
        //merge low-mid to mid+1
        //System.out.println("low high "+low+" "+high);
        //merge low-mid  to mid+1-high
        //size high-low+1

        int[] aux = new int[high+1];
        int l=low;int h=mid+1;
        for(int i=low;i<=high;i++) {
            //l should not be >mid
            //h should not be >high
            if(l<=mid && h<=high) {
                if(arr[l]<=arr[h]) {
                    aux[i]=arr[l++];
                } else {
                    aux[i]=arr[h++];
                }
                
            } else if(l>mid && h<=high) {
                    aux[i]=arr[h++];
                }
            else if(h>high && l<=mid) {
                    aux[i]=arr[l++];
                }
            
            
        }
        
        
        for(int i=low;i<=high;i++) {
            arr[i]=aux[i];
        }
        
    }
}
