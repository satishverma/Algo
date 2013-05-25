/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algods.BST;

/**
 *
 * @author sverma
 */
public class BST<Key extends Comparable<Key>,Value> {
    
    private Node root;
    
    private class Node {
        private Node right;
        private Node left;
        private Value val ;
        private Key key;
        public Node(Key k,Value v,int N) {
            this.key=k;
            this.val=v;
            this.N=N;     }
        private int N;
    } //Node Class
    
    
}
