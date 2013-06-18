/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algods.BitOps;

/**
 *
 * @author sverma
 */
public class BitTests {
    
    private static int nextPowerOfTwo(int n) {
        //what to do 
        //1.check if power of two
        int status = n &(n-1);
        boolean stat = status==0?false:true;
        boolean notZero = n==0?false:true;
        if(!stat) 
            return n;
        
        int p=1;
        while(p<n) p<<=1;
        return p;
        
    }
    
    private static boolean checkPowerOfTwo(int n) {
        int x = n&(n-1);
        return x==0;
    }
    
    
    public static void main(String args[]) {
        int num=33;
        System.out.println("Next num which is power of 2 : " + nextPowerOfTwo(num));
        
        
        num=28;
        System.out.println("Is power of two : "+ num +" " + checkPowerOfTwo(num));
    }
    
}
