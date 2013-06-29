/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algods.Strings;

/**
 *set[] = {'a', 'b'}, k = 3

Output:
aaa
aab
aba
abb
baa
bab
bba
bbb
 * @author sverma
 */
public class ComputeAllPermutation {
    
     private static void getAllPerm(char[] cA, int ht) {
         int numChar = cA.length;
         printAllKLengthRec(cA, "", numChar, ht);
     }
     
     
     // The main recursive method to print all possible strings of length k
    static void printAllKLengthRec(char set[], String prefix, int n, int k) {
         
        // Base case: k is 0, print prefix
        if (k == 0) {
            System.out.println(prefix);
            return;
        }
 
        // One by one add all characters from set and recursively
        // call for k equals to k-1
        for (int i = 0; i < n; ++i) {
             
            // Next character of input added
            String newPrefix = prefix + set[i];
             
            // k is decreased, because we have added a new character
            printAllKLengthRec(set, newPrefix, n, k - 1);
        }
    }
     
     public static void main(String[] args) {
         char[] charArr = {'a','b','c'};
         int height = 3;
         int numChar = charArr.length;
         getAllPerm(charArr, height);
     }
}
