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
		
		for(int i=0; i<E; ++i){
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken())-1;
			int v = Integer.parseInt(st.nextToken())-1;
			int w = Integer.parseInt(st.nextToken());
			
			map[u][v] = map[v][u] = Math.min(map[u][v], w);
		}
		
		// start node부터 i node까지의 최단거리
	    dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
	    
	    // 각 노드별로 방문한 적이 있는지 표시
	    visited = new boolean[V];
        Arrays.fill(visited, false);
	    
	    shortestPath(S, V);
	    
	    for(int d : dist){
	    	if(d == Integer.MAX_VALUE) System.out.println("INF");
	    	else System.out.println(d);
	    }
	    
		br.close();
	}
	//http://eversgreen.tistory.com/74
	public static int shortestPath(int start, int end){
        
        // 기저
        if(start == end){
            return dist[end];
        }
        
        // 방문한 노드들을 차례대로 담는다
        visited[start] = true;
        
        // 연결된 노드들 중 짧은 거리 노드의 인덱스
        int min=Integer.MAX_VALUE;
        
        for(int i=0; i<V; i++){
            
            // start node의 하위 트리 탐색
            // 조건1 : 방문이력x
            // 조건2 : start node와 연결됨
            if(map[start][i]!=Integer.MAX_VALUE && visited[i]==false){
                
                // 기존값과 start node를 경유해서 오는 거리 비교 후 최소거리로 업데이트
                if(dist[i] > dist[start] + map[start][i]){
                    dist[i] = dist[start] + map[start][i];
                }
                    
                
                // 다음 경로 node 갱신
                // 조건 : 최소거리값이 작은 노드
                if(min==Integer.MAX_VALUE || dist[min] > dist[i]){
                    min = i;
                }
                
            }
            
        }
        
        // 최소경로를 시작으로 다시 recursive 하게 방문한다.
        shortestPath(min, end);
        
        return 0;
	}
}
