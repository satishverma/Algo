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
    
    
    public int getHeight() {
        return getHeight(root);
    }
    
    
    private int getHeight(Node x) { 
        if(x==null) return 0; 
        return(1+Math.max(getHeight(x.left),getHeight(x.right)));
    }
    
    public int getNumLeaves() {
        return getNumLeaves(root);
    }
    
    private int getNumLeaves(Node x) {
        if(x==null) return 0;
        
        if(x.left==null && x.right==null) return 1;
        
        return (getNumLeaves(x.left)+getNumLeaves(x.right));
    }
    
    
    public int getTreeSize() {
        return getTreeSize(root);
    }
    
    private int getTreeSize(Node x) {
        if(x==null) return 0;
        return (1+getTreeSize(x.left)+getTreeSize(x.right));
    }
    
     public static void main(String[] args) {
        BST<Integer,String> bst = new BST<Integer,String>();
        
        bst.put(10,"ten");
        bst.put(20,"twenty");
        bst.put(3,"thirty"); 
        bst.put(40,"fourty");
        bst.put(5,"fifty");
        bst.put(13, "thirteen");
        bst.put(25, "twentyfive");
        bst.put(65, "sixtyfive");
        bst.put(1,"one"); 
        bst.put(85, "eightyfive");
        bst.printTree();
        
        System.out.println("Minimum : " + bst.min());
        System.out.println("Maximum : " + bst.max());
        
        System.out.println("Floor : " +bst.floor(15));
        System.out.println("Height : " +bst.getHeight());
        System.out.println("Number of Leaves: "+bst.getNumLeaves());
        System.out.println("Size of tree :" + bst.getTreeSize());
        
    } //testBST
     
     
     
    
}//BST


