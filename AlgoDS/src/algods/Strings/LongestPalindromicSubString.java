/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algods.Strings;

/**
 *
 * @author sverma
 */
public class LongestPalindromicSubString {

    private static String lpss(String str) {

        if (str == null || str == "") {
            return "";
        }

        boolean[][] isPalTable = new boolean[str.length()][str.length()];

        int maxLength = 1;
        for (int i = 0; i < str.length(); i++) {
            isPalTable[i][i] = true;
        }

        int start = 0;
        for (int i = 0; i < str.length() - 1; ++i) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                isPalTable[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        printTable(isPalTable);



        for (int k = 3; k <= str.length(); ++k) {
            // Fix the starting index
            for (int i = 0; i < str.length() - k + 1; ++i) {
                // Get the ending index of substring from starting index i and length k
                int j = i + k - 1;

                // checking for sub-string from ith index to jth index iff str[i+1]
                // to str[j-1] is a palindrome
                if (isPalTable[i + 1][j - 1] && str.charAt(i) == str.charAt(j)) {
                    isPalTable[i][j] = true;

                    if (k > maxLength) {
                        start = i;
                        maxLength = k;
                    }
                }
            }
        } //for k
        
        System.out.println("Length is " + maxLength);
        return str.substring(start, start+maxLength);
    }

    private static void printTable(boolean[][] table) {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if (table[i][j] == true) {
                    System.out.print(1 + " ");
                } else {
                    System.out.print(0 + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String s1 = "forgeeksskeegfor"; //geeksskeeg
        System.out.println("LongestPalindromic SubStr is : " + lpss(s1));


    }
}
