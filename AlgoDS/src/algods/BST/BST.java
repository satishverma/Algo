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
    
    
    //SIZE returns the number of nodes in the tree
    public int size() {
        return size(root);
    } //size
    
    private int size(Node x) {
        if(x==null) return 0;
        else return root.N;
    } //size
    
    public boolean  isEmpty() {
        return size()==0;
    }//isEmpty
    
    public boolean contains(Key key) {
        return get(key) != null;
    } //get

    // return value associated with the given key, or null if no such key exists
    public Value get(Key key) {
        return get(root, key);
    } //get

    private Value get(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else              return x.val;
    }//get
    
    public void put(Key key, Value val) {
        root = put(root, key, val);
    } //put

    private Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = put(x.left,  key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else              x.val   = val;
        x.N = 1 + size(x.left) + size(x.right);
        return x;
    } //put
    
    
    
    public void printTree() {
        printTree(root);
    }//printTree
    
    private void printTree(Node x) {
        if(x==null) return;
        printTree(x.left);
        System.out.println(x.key +" "+x.val);
        printTree(x.right);
    }//printTree
    
    //Min, max, floor, and ceiling
    
    public Key min() {
        if(min(root)==null) return null;
        return min(root).key;
    }
    
    private Node min(Node x) {
        if(x==null) return null;
        if(x.left==null) {
            return x;
        } else {
           return min(x.left);
        }
    } //Node
    
    
    public Key max() {
        if(max(root)==null) return null;
        return max(root).key;
        
    }
    
    private Node max(Node x) {
        if(x==null) return null;
        if (x.right!=null) {
            return max(x.right);
        } else {
            return x;
        }
    } //max
    
    public Key floor(Key k) {
        if(floor(root,k)==null) return null;
        return floor(root,k).key;
    } //floor
    
    private Node floor(Node x, Key k) {
        if (x == null) {
            return null;
        }
        int cmp = x.key.compareTo(k);
        if (cmp == 0) {
            return x;
        }

        //cmp>0 it means that x.key > input key  . floor is on left side
        if (cmp > 0) {
            return floor(x.left, k);
        }
        //cmp < 0 x.key < input key  

        Node t = floor(x.right, k);
        if (t != null) {
            return t;
        } else {
            return x;
        }

    } //floor
    
    
    
}//BST


