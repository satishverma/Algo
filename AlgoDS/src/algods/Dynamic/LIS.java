/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algods.Dynamic;

/**
 *{ 10, 22, 9, 33, 21, 50, 41, 60, 80 }  6  10 22 33 50 60 80
 * @author sverma
 */
public class LIS {
    private static int[] lisArray;
    public static void printArr() {
        for(int i=0;i<lisArray.length;i++) {
            System.out.print(lisArray[i] + " ");
        }
        System.out.println();
    }
    
    public static void lis(int[] intArr) {
        lisArray = new int[intArr.length];
        lisArray[0]=1;
        for(int i=0;i<intArr.length;i++) {
            int maxLen=1;
            
            for(int j=0;j<i;j++) {
                //get lisArray for 0 to i-1 and compare
                if(intArr[i]>intArr[j]) {
                    
                    if((lisArray[j]+1)>maxLen) maxLen=lisArray[j]+1;
                    
                }
                lisArray[i]=maxLen;
                
            }  //j
        }//i
    }
    
    public static void main(String[] args) {
        int[] intArr = { 10, 22, 9, 33, 21, 50, 41, 60, 80,88,79 };
        
        //What to do 
        // Find and Store the L(i) for each i
        lis(intArr);
        printArr();
    }
}
