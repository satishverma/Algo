/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algods.Strings;

/**
 * 
 * N! possible options
 *  
 * @author sverma
 */
public class ComputeAllPermutations {
    
    private static void permute(String s, int start,int end) {
        
        int i;
        if(start==end) {
            System.out.println(s);
        } else {
            
        }
        for(i=start;i<end;i++){
            s=swap(s,start,i);
            permute(s,start+1,end);
            s=swap(s,start,i);
        }
        
    }
    
    private static String swap(String s, int i,int j){
        char[] cArr =s.toCharArray();
        char tmp = cArr[i];
        cArr[i]=cArr[j];
        cArr[j]=tmp;
        return String.valueOf(cArr);
    }
    
    public static void main(String[] args) {
        String s ="AB";
        permute(s,0,s.length());
    }
}
