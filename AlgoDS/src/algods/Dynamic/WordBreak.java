/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algods.Dynamic;

import java.util.HashMap;

/**
 *
 * @author sverma
 */
public class WordBreak {
    public static HashMap<String,Integer> dMap = new HashMap<String,Integer>();
  
    public static boolean check(String p, String s) {
       return false;
    }
    
    public static boolean checkPresent(String s) {
        if (s.length()==0) return true;
        
        for (int i=0;i<s.length();i++) {
            if(dMap.containsKey(s.substring(0, i+1)) && checkPresent(s.substring(i+1))) {
                return true;
            } 
        }
        return false;
    }
    
    public static void main(String[] args) {
        String[] dict = { "i", "like", "sam", "sungs", "samsung", "mobile", "ice", "cream", "icecream", "man", "go", "mango"};
        String input2 ="igo";
        String input1 = "samsungss";
        
        for (int i=0;i<dict.length;i++) {
            dMap.put(dict[i], 1);
        }
        
        //get all prefixes
        String prefix,suffix;
        for (int i=0;i<input1.length();i++) {
            prefix = input1.substring(0, i+1);
            suffix = input1.substring(i+1,input1.length());
           // System.out.println("Testing with:::: "+prefix + " "+suffix);
            //boolean isPresent= check(prefix,suffix);
            //System.out.println("isPresent is " + isPresent);
        }
        
        
        System.out.println("isPresent is " +checkPresent(input1));
        
    }
    
}
