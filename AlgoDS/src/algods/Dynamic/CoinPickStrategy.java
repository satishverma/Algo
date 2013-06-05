/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algods.Dynamic;

/**
 *
 * @author sverma
 */
public class CoinPickStrategy {
    
    //5, 3, 7, 10
    //8, 15, 3, 7
    
    private static void solveMaxCoinPick(int[] arr) {
        int[][] F = new int[arr.length][arr.length];
        for (int i=0;i<F.length;i++) {
            F[i][i]=0;
        }
        for(int i=0;i<F.length-1;i++) {
            F[i][i+1]= arr[i+1]>arr[i]?arr[i+1]:arr[i];
        }
        
        int size=4;
        System.out.println(computeMax(F,size,arr));
        
       // printF(F);
    }
    
    
    private static int computeMax(int[][] F,int size,int[] arr) {
        if(size>arr.length) {
            return F[0][arr.length-1];
        }
       
        for(int i=0,j=i+size-1;j<arr.length;i++,j++) {
            System.out.println("range of i and j are : "+ i +" "+j);
            
            //choose i 
            int variablePart1 = F[i+2][j]>F[i+1][j-1]?F[i+1][j-1]:F[i+2][j];
            int choice1 = arr[i] + variablePart1;
            
            //choose j
            int variablePart2 = F[i][j-2]>F[i+1][j-1]?F[i+1][j-1]:F[i][j-2];
            int choice2 = arr[j]+variablePart2;
            
            F[i][j] = choice1>choice2?choice1:choice2; 
            printF(F);
            
        }
        
        size=size+2;
        return computeMax(F,size,arr);
        
    }
    
    private static void printF(int[][] F) {
        for (int i=0;i<F.length;i++) {
            for (int j=0;j<F.length;j++) {
                System.out.print(F[i][j]+" ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        
        int[] intArr = {20, 30, 2, 2, 2, 10};
        solveMaxCoinPick(intArr);
        
        
    } //main 
    
}
