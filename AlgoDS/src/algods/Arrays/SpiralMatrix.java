/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algods.Arrays;

/**
 *
 * @author sverma
 */
public class SpiralMatrix {
    
    
    private static void printMatrix(int[][] matrix,int nR,int nC) {
        for(int i=0;i<nR;i++) {
            for(int j=0;j<nC;j++) {
                   System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        
        System.out.println();
    }
    
    
    private static void getSpiralMatrix(int[][] matrix,int nR,int nC) {
        int i=0;
        int startRow=0;
        int startCol =0;
        int endRow=nR;
        int endCol=nC;
        
        while(startRow<endRow && startCol<endCol) {
           
            for(i=startCol; i<endCol;i++ ) {
                System.out.print(matrix[startRow][i]+" ");
            }
            startRow++;
            for(i=startRow;i<endRow;i++){ 
                System.out.print(matrix[i][endCol-1]+" ");
            }
            endCol--;
            
            if(startRow<endRow) {
                for(i=endCol-1;i>=startCol;i--) {
                    System.out.print(matrix[endRow-1][i]+" ");
                }
                endRow--;
            }
            
            if(startCol<endCol) {
                for(i=endRow-1;i>=startRow;i--) {
                    System.out.print(matrix[i][startCol]+" ");
                }
                startCol++;
            }
            
        } //while 
        
        
        //printMatrix(matrix,nR,nC);
    }
    
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4,5},{6,7,8,9,0},{1,2,3,4,5},{6,7,8,9,0},{1,2,3,4,5}};
        printMatrix(matrix,5,5);
        
        getSpiralMatrix(matrix,5,5);
        
        
        int[][] matrix2 = {{1, 2, 3, 4, 5, 6},
            {7, 8, 9, 10, 11, 12},
            {13, 14, 15, 16, 17, 18}
        }; 
        
        System.out.println();
        System.out.println("test matrix 2");
        printMatrix(matrix2,3,6);
        getSpiralMatrix(matrix2,3,6);
        
    }
}
