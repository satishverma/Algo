/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algods.Graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author sverma
 */
public class Search {
    
    public static Queue<Vertex> queue = new LinkedList<Vertex>();
    public static Stack<Vertex> stack = new Stack<Vertex>();
    
    private static void BFS(Graph G, Vertex V) {

        queue.add(V); 
        while(!queue.isEmpty()) {
            Vertex v = queue.poll();
            System.out.println("Done " +v.toString());
            v.isVisited=true;
            Iterable<Vertex> itV = G.adjacentTo(v.name);
            for(Vertex vert:itV) {
                if(vert.isVisited==false) {
                    queue.add(vert);vert.isVisited=true;
    
                }
            }
        }
        
        Iterable<Vertex> itVert = G.getVertices();
        for(Vertex vertex:itVert) {
            vertex.isVisited=false;
        }
    }//BFS
    
    
    private static void DFS(Graph G, Vertex V) {
        System.out.println("DFS");
       // System.out.println(V.name);
        V.isVisited=true;
        stack.push(V);
        
        while(!stack.empty()) {
            Vertex u = stack.pop();
            System.out.println(u.name);
            Iterable<Vertex> itV = G.adjacentTo(u);
            for(Vertex v:itV) {
                if(v.isVisited==false) {
                    stack.push(v);
                    v.isVisited=true;
                }
            }
            
        }
    }
    
    public static void main(String[] args) {
      
		Graph G = new Graph();
		G.addEdge("A", "B");
		G.addEdge("A", "C");
		G.addEdge("C", "D");
		G.addEdge("D", "E");
		G.addEdge("D", "G");
		G.addEdge("E", "G");
		G.addVertex("H");
                
                for (Vertex v : G.getVertices()) {
			System.out.print(v + ": ");
			for (Vertex w : G.adjacentTo(v.name)) {
				System.out.print(w + " ");
			}
			System.out.println();
		}//for
                
                
                
                //BFS
                
                BFS(G,G.getVertex("A"));
                
                
                //DFS
                DFS(G,G.getVertex("A"));
    }//main
    
}//Search
