/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algods.Strings;

import java.util.ArrayList;

/**
 * 
 * N! possible options
 *  
 * @author sverma
 */
public class ComputeAllPermutations {
    
    private static int count=0;
    
    private static void printCount() {
        System.out.println("Count "+count);
    }
   
     private static void permute(char[] alphabet) {
         StringBuilder s = new StringBuilder();
         s.append("");
         System.out.println(s);
         permuteAll(s,0,alphabet);
     }
     
     private static void permuteString(char[] alphabet) {
         //fix elements first 0 elements then 1 then 2 and so on until the size of 
         //signature permuteString (alphabet, numFix
         permuteString(alphabet,0);
        
     }
     
    
     
     private static void permuteString(char[] alphabet,int numFix) {
         //swap element at numFix with elements at numFix +1 ,.....
         if(numFix==alphabet.length) {
             System.out.println(new String(alphabet));
             return;
         }
         for(int i=numFix;i<alphabet.length;i++) {
             String s = swap(alphabet,numFix,i);
             if(s!=null) {
                 //System.out.println(s);
                 permuteString(s.toCharArray(),numFix+1);
             }
             
         }
         
     }
     
     private static String swap(char[] alphabet,int numFix,int i) {
         
         //System.out.println("numFix "+numFix +" i " +i);
         char[] newStr= new char[alphabet.length];
         for(int j=0;j<alphabet.length;j++ ) {
             newStr[j]=alphabet[j];
         }
         newStr[numFix]=alphabet[i];
         newStr[i]=alphabet[numFix];
         String s = new String(newStr);
         return s;
     }
     
     private static void permuteAll(StringBuilder s,int len,char[] alphabet) {
         if(s.length()==alphabet.length) {
             System.out.println(s);
             count++;
             return;
         } else {
             for(int i=0;i<alphabet.length;i++) {
                 StringBuilder ss =  new StringBuilder(s);
                 ss.append(alphabet[i]);
                 //System.out.println(ss);
                 permuteAll(ss,len+1,alphabet);
             }
         }
     }
    
     public static void main(String[] args) {
         char[] alphabet = {'a','b','c','d'};
         //permute(alphabet);
         //printCount();
         permuteString(alphabet); //n! is what we expect         
     }
}
