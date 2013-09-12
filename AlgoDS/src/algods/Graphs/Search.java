/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algods.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
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
    public static Queue<ID> queueID = new LinkedList<ID>();
    public static int[][] isVisited;
    public static HashMap<Integer,ID> idMap = new HashMap<Integer,ID>();
    
    private static void BFS(Graph G, Vertex V) {
        System.out.println("BFS");
        queue.add(V); 
        
        while(!queue.isEmpty()) {
            Vertex v = queue.poll();
            if(v.isVisited==false)
                System.out.println("Done " +v.toString());
            v.isVisited=true;
            Iterable<Vertex> itV = G.adjacentTo(v.name);
            for(Vertex vert:itV) {
                if(vert.isVisited==false) {
                    queue.add(vert);
    
                }
            }
        }
        
        Iterable<Vertex> itVert = G.getVertices();
        for(Vertex vertex:itVert) {
            vertex.isVisited=false;
        }
        
        System.out.println("BFS Ends");
    }//BFS
    
    
    private static void DFS(Graph G, Vertex V) {
        System.out.println("DFS");
      
        
        stack.push(V);
        
        while(!stack.empty()) {
            Vertex u = stack.pop();
            System.out.println(u.name);
            u.isVisited=true;
            Iterable<Vertex> itV = G.adjacentTo(u);
            for(Vertex v:itV) {
                if(v.isVisited==false) {
                    stack.push(v);
                    v.isVisited=true;
                }
            }
            
        }
        
        
        System.out.println("DFS Ends");
    }
    
    
    private static class ID {
        public int i;public int j;
        public boolean isVisited=false;
        public ID(int i,int j) {
            this.i=i;this.j=j;
        }
    }
    
    private static int findNumIslands() {
        
        int[][] islandMat = {
            {1, 1, 0, 0, 0},
            {0, 1, 0, 0, 1},
            {1, 0, 0, 1, 1},
            {0, 0, 0, 0, 0},
            {1, 0, 1, 0, 1}
        };
        
        
        for(int i=0;i<islandMat.length;i++) {
            for(int j=0;j<islandMat.length;j++) {
            idMap.put(i*islandMat.length+j,new ID(i,j));
          }
        }
        
        int x = countIslands(islandMat);
        System.out.println("NumIslands" + x);
        return x;
    }
    
    private static int countIslands(int[][] islandMat) {
        int size = islandMat.length;
        isVisited = new int[size][size];
        int numIslands=0;
        //run bfs on all possible ids (i,j) 
        
        for(int i=0;i<size;i++) {
            for(int j=0;j<size;j++) {
                if(isVisited[i][j]==0) {
                    
                    if(islandMat[i][j]==1) {
                        System.out.println("Running BFS ISLAND "+i+" "+j);
                         BFS_Island(islandMat,idMap.get(j+i*size));
                         numIslands++;
                    }
                }//if
                
            }//for
        }//for
        
        return numIslands;
    }
    
    
    public static void BFS_Island(int[][] islandMat, ID id_) {
        
        queueID.add(id_);
        
        while(!queueID.isEmpty()) {
            //System.out.println(queueID.size());
            
            
            ID id = queueID.poll();
            id.isVisited=true;
            isVisited[id.i][id.j]=1;
            System.out.println("Dealing with "+id.i+" "+id.j);
            //get neighbors
            //8 possible options 
            ArrayList<ID> list_ = new ArrayList<ID>();
            for (int k = 0; k < 8; k++) {
                if (id.i - 1 >= 0 && id.j - 1 >= 0) {
                    if (islandMat[id.i - 1][id.j - 1] == 1  && isVisited[id.i-1][id.j-1]==0) {
                        list_.add(new ID(id.i - 1, id.j - 1));
                        queueID.add(new ID(id.i - 1, id.j - 1));
                        isVisited[id.i-1][id.j-1]=1;
                    }
                }
                if (id.i - 1 >= 0 ) {
                    if (islandMat[id.i - 1][id.j] == 1 && isVisited[id.i-1][id.j]==0) {
                        list_.add(new ID(id.i - 1, id.j));
                        queueID.add(new ID(id.i - 1, id.j));
                        isVisited[id.i-1][id.j]=1;
                    }
                }
                if (id.i - 1 >= 0 && id.j + 1 < islandMat.length) {
                    if (islandMat[id.i - 1][id.j + 1] == 1 && isVisited[id.i-1][id.j+1]==0) {
                        list_.add(new ID(id.i - 1, id.j + 1));
                        queueID.add(new ID(id.i - 1, id.j+1));
                        isVisited[id.i-1][id.j+1]=1;
                    }
                }
                if (id.j - 1 >= 0) {
                    if (islandMat[id.i][id.j - 1] == 1 && isVisited[id.i][id.j-1]==0) {
                        list_.add(new ID(id.i, id.j - 1));
                        queueID.add(new ID(id.i , id.j-1));
                        isVisited[id.i][id.j-1]=1;
                    }
                }
                if (id.j + 1 < islandMat.length) {
                    if (islandMat[id.i][id.j + 1] == 1 && isVisited[id.i][id.j+1]==0) {
                        list_.add(new ID(id.i, id.j + 1));
                        queueID.add(new ID(id.i , id.j+1));
                        isVisited[id.i][id.j+1]=1;
                    }
                }
                if (id.i + 1 < islandMat.length && id.j - 1 >= 0) {
                    int row = id.i+1;
                    int col = id.j-1;
                    //System.out.println("RowCol "+row+" "+col);
                    if (islandMat[id.i + 1][id.j - 1] == 1 && isVisited[id.i+1][id.j-1]==0) {
                        
                        list_.add(new ID(id.i + 1, id.j - 1));
                        queueID.add(new ID(id.i + 1, id.j-1));
                        isVisited[id.i+1][id.j-1]=1;
                    }
                }
                if (id.i + 1 < islandMat.length) {
                    if (islandMat[id.i + 1][id.j] == 1 && isVisited[id.i+1][id.j]==0) {
                        list_.add(new ID(id.i + 1, id.j));
                        queueID.add(new ID(id.i + 1, id.j));
                        isVisited[id.i+1][id.j]=1;
                    }
                }
                if (id.i + 1 < islandMat.length && id.j + 1 < islandMat.length) {
                    if (islandMat[id.i + 1][id.j + 1] == 1 && isVisited[id.i+1][id.j+1]==0) {
                        list_.add(new ID(id.i + 1, id.j + 1));
                        queueID.add(new ID(id.i + 1, id.j+1));
                        isVisited[id.i+1][id.j+1]=1;
                    }
                }

            } //list_
            System.out.println("Size "+list_.size());
            
            
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
                
                //FIND Number of ISLANDS in 2-D bool matrix
                System.out.println("Num Islands");
                findNumIslands();
    }//main
    
}//Search
