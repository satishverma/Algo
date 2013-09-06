/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algods.Dynamic;

/**
 *
 * @author sverma
 */
public class MaxProdCutting {
    
    private static int[] mpA;
    
    private static int[] maxProdCutting(int n) {
        
        
        
        for(int i=3;i<n+1;i++) {
           int max =0;
           //int lastVal = mpA[i-1];
           System.out.println("i "+i);
           
           for(int j=1;j<i;j++) {
               int currVal = mpA[j]*(i-j);
               int currVal2 = j*(i-j);
               //System.out.println(currVal);
               if(currVal>max) 
               {
                   max=currVal;
               }
               if(currVal2>max) {
                   max=currVal2;
               }
           }//for j
           
           mpA[i]=max;
            
           
        } //i
        
        return mpA;
    }
    
    
    private static void printArray() {
        for(int i=0;i<mpA.length;i++) 
            System.out.println(i+" "+mpA[i]);
    }
    
    public static void main(String[] args) {
        final int n=10;
        MaxProdCutting.mpA = new int[n+1];
        MaxProdCutting.mpA[1]=1;MaxProdCutting.mpA[2]=1;MaxProdCutting.mpA[0]=1;
        maxProdCutting(n);
        MaxProdCutting.printArray();
        
    } //main
    
}
