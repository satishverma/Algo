/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algods.Dynamic;

/**
 *
 * @author sverma
 */
public class CutRod {
    
    private static int cutRod(int[] price, int n) {
        if(n<0) return 0;
        int max_val = 0;
        
        for (int i = 0; i<n; i++)
         max_val = max(max_val, price[i] + cutRod(price, n-i-1));
 
        return max_val;
    }
    
    private static int max(int a, int b) { return (a > b)? a : b;}
    
    public static void main(String[] args) {
        int price[] = {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println("Max Possible Value is: "+ cutRod(price,price.length));
    }
}
