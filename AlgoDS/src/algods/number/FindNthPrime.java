/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algods.number;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author sverma
 */
public class FindNthPrime {
    private static int numPrime = 0;
    
    /**
     * 
     * @param primeSet 
     */
    private static void printPrimeSet(Set<Integer> primeSet) {
        int count=0;
        for(int i:primeSet) {
            count++;
            System.out.println(count + " " + i);
            
        }
    }
    
    private static boolean testPrime(int testVal,Set<Integer> primeSet) {
        
        for(int i:primeSet) {
           if(testVal%i==0) return false;   
        }
        return true;
    } //testPrime
    
    public static void main(String[] args) {
        //find the nth prime 
        Set<Integer> primeSet = new HashSet<Integer>();
        primeSet.add(2);
        numPrime++;
        
        int n= 15;
        
        for(int i=3;i< Integer.MAX_VALUE;i+=2) {
            
            if(primeSet.size()==n) {
                 
                printPrimeSet(primeSet);
                break;
            }
            if(testPrime(i,primeSet)) {
                primeSet.add(i);
                numPrime++;
            }
            
        } //for
        
        
        
    }
    
}
