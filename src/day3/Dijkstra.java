package day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Dijkstra {
	private static int[] dist = null;
	private static boolean[] visited = null;
	private static int[][] map = null;
	private static int V = 0;
	private static int E = 0;
	private static int S = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(br.readLine());
		
		map = new int[V][V];
		
		for(int i=0; i<V; ++i)
			Arrays.fill(map[i], Integer.MAX_VALUE);
		
		for(int i=0; i<E; ++i){
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken())-1;
			int v = Integer.parseInt(st.nextToken())-1;
			int w = Integer.parseInt(st.nextToken());
			
			map[u][v] = Math.min(map[u][v], w);
		}
		
	    dist = new int[V];
	    Arrays.fill(dist, Integer.MAX_VALUE);
	    
	    visited = new boolean[V];
	    Arrays.fill(visited, false);
	    
    	dist[S-1] = 0;
    	shortestPath(S-1);
	    
        StringBuilder sb = new StringBuilder();
	    for(int d : dist){
	    	if(d == Integer.MAX_VALUE) sb.append("INF").append("\n");
	    	else sb.append(d).append("\n");
	    }
	    System.out.println(sb.toString());
		br.close();
	}
	public static int shortestPath(int start){
        if(start >= V){
        	return 0;
        }
        visited[start] = true;
        int min=Integer.MAX_VALUE;
        
        for(int i=0; i<V; i++){
            if(map[start][i]!=Integer.MAX_VALUE && visited[i]==false){
                if(dist[i] > dist[start] + map[start][i]){
                    dist[i] = dist[start] + map[start][i];
                }
                if(min==Integer.MAX_VALUE || dist[min] > dist[i]){
                    min = i;
                }
                
            }
            
        }
        shortestPath(min);
        
        return 0;
	}
}
