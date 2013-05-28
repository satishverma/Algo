/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algods.Strings;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author sverma
 */
public class RemoveDuplicatesFromString {
    
    
    private static String removeDuplicates(String input) {
        if (input==null || input.length()==1) return input;
        Set<Character> setChar = new HashSet<Character>();
        StringBuilder s = new StringBuilder();
        for(int i=0;i<input.length();i++) {
            if(!setChar.contains(input.charAt(i))) {
                setChar.add(input.charAt(i));
                s.append(input.charAt(i));
            }
        }
        return s.toString();
    }
    
    
    
    public static void main(String[] args) {
        String input = "tree traversal";
        System.out.println(removeDuplicates(input));
    }
    
}
