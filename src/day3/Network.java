package day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Network {
	private static int[][] map = null;
	private static int N = 0;
	private static int M = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for(int i=0; i<N; ++i)
			Arrays.fill(map[i], Integer.MAX_VALUE);
		
		StringTokenizer st = null;
		for(int i=0; i<M; ++i){
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken())-1;
			int v = Integer.parseInt(st.nextToken())-1;
			int w = Integer.parseInt(st.nextToken());
			
			map[u][v] = map[v][u] = w;
		}
		
	    int[] sv = new int[N];

	    int count = 0;
	    
	    sv[count++] = 0;
	    while(count < N) {
	      int min = Integer.MAX_VALUE;
	      int from = 0;
	      for (int i=0; i<count; i++) {
	        for (int j=0; j<N; j++) {
	          if ( map[sv[i]][j] != 0 && map[sv[i]][j] < min) {
	            from = sv[i]; 
	            sv[count] = j; 
	            min = map[sv[i]][j];
	          }
	        }
	      }
	     if (isCycle(sv, sv[count], count)) {
	        sv[count--] = 0; 
	      }
	     map[from][sv[count]] = 0;
	     map[sv[count]][from] = 0;
	     count++; 
	    }
	    int total = 0;
	    for(int i : sv){
	    	total+=i;
	    }
	    System.out.println(total);
		br.close();
	}
	static boolean isCycle(int[] sv, int val, int cnt) {
	    for (int i =0; i<cnt; i++) {
	      if (sv[i] == val) {
	        return true;
	      }
	    }
	    return false;
	  }
}
