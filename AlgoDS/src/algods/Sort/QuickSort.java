/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algods.Sort;

import java.util.Random;

/**
 *
 * @author sverma
 */
public class QuickSort {
    
    private static int[] quicksort(int[] arr) {
        qsort(arr,0,arr.length);
        printArray(arr);
        return arr;
    }
    
    private static void qsort(int[] arr,int low,int high) {
        
        //Find Pivot
        //Partition Array
        //Recurse
        if(high<=low) return ;
        int partition=partition(arr,low,high);
        //System.out.println(partition);
        //QSORT 0---partition-1
        qsort(arr,0,partition-1);
        qsort(arr,partition,high);
        
    }
    
    
    private static int partition(int[] arr,int low,int high) {
        
        int partition=-1;int pivot=low;
        //low is included so is high is not included
        int pivotValue =  arr[low];
        partition=low+1;
        //printArray(arr);
        for(int j=low+1;j<high;j++) {
            if(arr[j]>=pivotValue) {
                //do nothing
            } else {
                int tmp=arr[partition];
                arr[partition]=arr[j];
                arr[j]=tmp;
                partition++;
            }
        }
        //partition is the value of the start of the data>pivot
        printArray(arr);
        //System.out.println(partition);
        int tmp=arr[partition-1];

        arr[partition-1]=arr[pivot];

        arr[pivot]=tmp;
        //printArray(arr);
        return partition;
    } //partition
            
            
   private static void printArray(int[] arr) {
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        final int n=10;
        int[] intArray = new int[n];
        
        
        //Random Init the Array
        Random rnd = new Random();
        for(int i=0;i<intArray.length;i++) {
            intArray[i]=rnd.nextInt(50);
        }
         
        System.out.println("Input Array");
        printArray(intArray);
         
         //quicksort returns an array
         int[] x=(quicksort(intArray));
         
    }
    
}
