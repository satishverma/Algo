/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algods.Trie;

/**
 *
 * @author sverma
 */
public class TrieST<Value> {
    private static final int R = 256;        // extended ASCII

    private Node root = new Node();

    private static class Node {
        private Object val;
        private Node[] next = new Node[R];
    }
    
    public void put(String key, Value val) {
        root = put(root, key, val, 0);
    }
    
    private Node put(Node x, String key, Value val, int d) {
        if (x == null) {
          // System.out.println("null");
           x = new Node();
        } else {
           // System.out.println("not null");
        }
        
        if (d == key.length()) {
            x.val = val;
            return x;
        }
        char c = key.charAt(d);
        x.next[c] = put(x.next[c], key, val, d+1);
        return x;
    }
    
    
    public boolean contains(String key) {
        return get(key) != null;
    }

    public Value get(String key) {
        Node x = get(root, key, 0);
        if (x == null) return null;
        return (Value) x.val;
    }

    private Node get(Node x, String key, int d) {
        if (x == null) return null;
        if (d == key.length()) return x;
        char c = key.charAt(d);
        return get(x.next[c], key, d+1);
    }

    
    
    public static void main(String[] args) {
        TrieST<Integer> trie = new TrieST<Integer>();
        trie.put("HE", 1);
        trie.put("SHELL",2);
        System.out.println(trie.get("SHELL"));
    }
}
