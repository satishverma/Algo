/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algods.Strings;

/**
 *
 * @author sverma
 */
public class PatternKMP {

    private static String KMPSearch(String patter, String text) {
        char[] pattern = patter.toCharArray();
        char[] txt = text.toCharArray();

        int[] lps = computeLPSArray(pattern);

        printArray(lps);

        int i=0, j=0;
        while (i < txt.length) {
            if (pattern[j] == txt[i]) {
                j++;
                i++;
            }

            if (j == pattern.length) {
                int index = i - j;
                System.out.println("Found pattern at index  " + index);
                //j = lps[j - 1];
            } // mismatch after j matches
            else if (pattern[j] != txt[i]) {
                // Do not match lps[0..lps[j-1]] characters,
                // they will match anyway
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i = i + 1;
                }
            }
        }

        return null;
    }

    private static void printArray(int[] lps) {
        for (int i = 0; i < lps.length; i++) {
            System.out.print(lps[i] + " ");
        }
        System.out.println();
    }

    private static int[] computeLPSArray(char[] pattern) {
        int[] lps = new int[pattern.length];
        int prevLongestPrefSuff = 0;
        lps[0] = 0; // lps[0] is always 0 
        int i = 1;

        while (i < pattern.length) {
            if (pattern[i] == pattern[prevLongestPrefSuff]) {
                prevLongestPrefSuff++;
                lps[i] = prevLongestPrefSuff;
                i++;
            } else {
                if (prevLongestPrefSuff == 0) {
                    lps[i] = 0;
                    i++;
                } else {
                    prevLongestPrefSuff = lps[prevLongestPrefSuff - 1];
                }
            }

        } //while

        return lps;
    }

    public static void main(String[] args) {
//        String txt = "ABABDABACDABABCABAB";
//        String pattern = "ABABCABAB";
        String txt ="apple";
        String pattern="pple";
        KMPSearch(pattern, txt);

    }
}
