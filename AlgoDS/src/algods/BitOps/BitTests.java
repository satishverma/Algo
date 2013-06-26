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
    
    private static int flipAtoB(int a, int b) {
        int count=0;
        int z = a ^ b;
        while(z>0) {
            count += z & 1;
            z=z>>1;
        }
        
        return count;
    }
    
    private static int swapEvenOddBits(int x) {
        // Get all even bits of x 1010
        int even_bits = x & 0xAAAAAAAA;

        // Get all odd bits of x 0101
        int odd_bits = x & 0x55555555;
 
        even_bits >>= 1;  // Right shift even bits
        odd_bits <<= 1;   // Left shift odd bits

        return (even_bits | odd_bits); // Combine even and odd bits
    } //swapEvenOddBits
    
    private static boolean checkPowerOfTwo(int n) {
        int x = n&(n-1);
        return x==0;
    }
    
    
    public static void main(String args[]) {
        int num=33;
        System.out.println("Next num which is power of 2 : " + nextPowerOfTwo(num));
        
        
        num=28;
        System.out.println("Is power of two : "+ num +" " + checkPowerOfTwo(num));
        
        System.out.println(swapEvenOddBits(23));
        System.out.println("Flip Number of Changes Needed: " + flipAtoB(73,21));
    }
    
}
