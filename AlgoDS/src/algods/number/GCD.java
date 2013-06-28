/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algods.number;

/**
 *
 * @author sverma
 */
public class GCD {
    
    private static int getGCD(int a , int b) {
        int i; int j;
        if(a==b) return a;
        if (a==1 || b==1) return 1;
        if(a>b) {
            i=a;
            j=b;
        } else {
            i=b;
            j=a;
        }
        return (getGCD(i-j,j));
    } //getGCD
    
    public static void main(String[] args) {
        
        int a=180;
        int b =47;
        
        //assume a > b else make a>b
        System.out.println("GCD");
        System.out.println(getGCD(a,b));
        
    }
}
