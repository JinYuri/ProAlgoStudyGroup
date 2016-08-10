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
		
		// start node���� i node������ �ִܰŸ�
	    dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
	    
	    // �� ��庰�� �湮�� ���� �ִ��� ǥ��
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
        
        // ����
        if(start == end){
            return dist[end];
        }
        
        // �湮�� ������ ���ʴ�� ��´�
        visited[start] = true;
        
        // ����� ���� �� ª�� �Ÿ� ����� �ε���
        int min=Integer.MAX_VALUE;
        
        for(int i=0; i<V; i++){
            
            // start node�� ���� Ʈ�� Ž��
            // ����1 : �湮�̷�x
            // ����2 : start node�� �����
            if(map[start][i]!=Integer.MAX_VALUE && visited[i]==false){
                
                // �������� start node�� �����ؼ� ���� �Ÿ� �� �� �ּҰŸ��� ������Ʈ
                if(dist[i] > dist[start] + map[start][i]){
                    dist[i] = dist[start] + map[start][i];
                }
                    
                
                // ���� ��� node ����
                // ���� : �ּҰŸ����� ���� ���
                if(min==Integer.MAX_VALUE || dist[min] > dist[i]){
                    min = i;
                }
                
            }
            
        }
        
        // �ּҰ�θ� �������� �ٽ� recursive �ϰ� �湮�Ѵ�.
        shortestPath(min, end);
        
        return 0;
	}
}
