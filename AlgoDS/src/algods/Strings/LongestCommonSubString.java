/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algods.Strings;

/**
 *
 * @author sverma
 */
public class LongestCommonSubString {

    private static String lcss(String str1, String str2) {


        StringBuilder sb = new StringBuilder();
        if (str1 == null || str1.isEmpty() || str2 == null || str2.isEmpty()) {
            return "";
        }

        // ignore case
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        // java initializes them already with 0
        int[][] num = new int[str1.length()][str2.length()];
        int maxlen = 0;
        int lastSubsBegin = 0;

        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    if ((i == 0) || (j == 0)) {
                        num[i][j] = 1;
                    } else {
                        num[i][j] = 1 + num[i - 1][j - 1];
                    }

                    if (num[i][j] > maxlen) {
                        maxlen = num[i][j];
                        // generate substring from str1 => i
                        int thisSubsBegin = i - num[i][j] + 1;
                        if (lastSubsBegin == thisSubsBegin) {
                            //if the current LCS is the same as the last time this block ran
                            sb.append(str1.charAt(i));
                        } else {
                            //this block resets the string builder if a different LCS is found
                            lastSubsBegin = thisSubsBegin;
                            sb = new StringBuilder();
                            sb.append(str1.substring(lastSubsBegin, i + 1));
                        }
                    }
                }
            }
        }

        return sb.toString();
    }

public static void main(String[] args) {
       
        //Dynamic Programming
        String s1 = "Please, peter go swimming!";
        String s2 = "I’m peter goliswi";
        
        String lcs = lcss(s1,s2);
        System.out.println("LCS IS : " + lcs);
        
    }//main
}
