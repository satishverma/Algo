/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algods.Strings;

/**
 *
 * @author sverma
 */
public class NextPlaindromeNumber {

    private static int oddOrEven(int t) {
        int count = 0;
        if (t == 0) {
            return 1;
        }
        while (t > 0) {
            t = t / 10;
            count = (count + 1) % 2;
        }
        return count;
    }

    private static String flipEven(String s) {
        char[] cArr = s.toCharArray();
        for (int i = 0; i < cArr.length / 2; i++) {
            cArr[cArr.length - i - 1] = cArr[i];
        }
        return (String.valueOf(cArr));
    }

    private static String updateMiddleEven(String s) {
        char[] cArr = s.toCharArray();
        cArr[cArr.length / 2 - 1]++;
        cArr[cArr.length / 2]++;

        return (String.valueOf(cArr));
    }

    private static boolean middleNotNineEven(String s) {
        char[] cArr = s.toCharArray();
        if (cArr[cArr.length / 2 - 1] != '9') {
            return true;
        }
        return false;
    }

    private static String roundUpEven(String s) {
        char[] cArr = s.toCharArray();
        int i = cArr.length / 2;
        while (i > 0 && cArr[i] == '9') {
            cArr[i] = '0';
            i--;
        }
        cArr[i]++;

        return (String.valueOf(cArr));
    }

    private static String getNextPalindrome(String input, String type) {
        if (type == "even") {
            /*
             * TO DO 
             * take the middle and flip, if larger return
             * else if middle is not 9, incread
             * else round up n flip
             * 
             */
            String s1 = flipEven(input);
            //System.out.println(s1);
            if (Integer.parseInt(s1) > Integer.parseInt(input)) {
                return s1;
            } else {
                if (middleNotNineEven(input)) {
                    return updateMiddleEven(s1);
                } else {
                    String s2 = roundUpEven(input);
                    return flipEven(s2);
                }
            }

        }

        if (type == "odd") {
            //Algo 
            //Flip and see if value is larger, return if ok 
            //check if middle is 9, true then upgrade and flip 
            //if middle is not 9 increase middle n return 
            String s1 = flipOdd(input);
            //compare s1 with input 
            if (Integer.parseInt(s1) > Integer.parseInt(input)) {
                System.out.println(s1);
                return s1;
            } else {
                if (middleNotNineOdd(input)) {
                    return updateMiddleOdd(s1);
                } else {
                    //middle is 9 and flip is not enough 
                    //round up       
                    String s2 = roundUpOdd(input);
                    return flipOdd(s2);
                }
            }
        } //if odd case 
        return null;
    } //getNextPalindrome 

    private static String roundUpOdd(String input) {
        char[] cArr = input.toCharArray();
        cArr[cArr.length / 2 - 1]++;
        for (int i = cArr.length / 2; i < cArr.length; i++) {
            cArr[i] = '0';
        }
        return String.valueOf(cArr);
    }

    private static String updateMiddleOdd(String input) {
        char[] cArr = input.toCharArray();
        cArr[cArr.length / 2]++;
        return String.valueOf(cArr);
    } //updateMiddleOdd

    private static String flipOdd(String s) {
        char[] cArr = s.toCharArray();
        for (int i = 0; i < cArr.length / 2; i++) {
            cArr[cArr.length - 1 - i] = cArr[i];
        }
        return new String(cArr);
    } //flipOdd

    private static boolean middleNotNineOdd(String input) {
        return input.charAt(input.length() / 2) != '9' ? true : false;
    } //middleNotNineOdd

    public static void main(String[] args) {
        int input = 8999;
        String type;
        type = oddOrEven(input) == 1 ? "odd" : "even";
        //System.out.println(type);

        //System.out.println(flipOdd(Integer.toString(input)));
        //System.out.println(middleNotNineOdd(Integer.toString(input)));
        //System.out.println(updateMiddleOdd(Integer.toString(input)));
        System.out.println("Input is : " + input);
        System.out.println("Next Palindrome is: " + getNextPalindrome(Integer.toString(input), type));
    }
}
