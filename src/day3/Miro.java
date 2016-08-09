package day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Miro {
	private static int[][] map = null;
	private static int[][] visited = null;
	private static int N = 0;
	private static int M = 0;
	private static ArrayDeque<Integer> q = new ArrayDeque<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new int[N][M];
		
		for(int i=0; i<N; ++i){
			String row = br.readLine();
			for(int j=0; j<M; ++j){
				map[i][j] = Integer.valueOf(row.charAt(j));
			}
		}
		
		
		
		br.close();
	}
	
	public static void bfs(int x, int y){
        visited[x][y] = 1;
        q.add(x*1000+y);
        while(!q.isEmpty()){
        	int temp = q.poll();
        	int tempX = temp/1000;
        	int tempY = temp%1000;
        	if(tempX+1<N && map[tempX+1][tempY]==1 && visited[tempX+1][tempY]!=1){
        		visited[tempX+1][tempY] = 1;
        		q.add(temp+1000);
        	}
        	if(tempX-1>=0 && map[tempX-1][tempY]==1 && visited[tempX-1][tempY]!=1){
        		visited[tempX-1][tempY] = 1;
        		q.add(temp-1000);
        	}
        	if(tempY+1<M && map[tempX][tempY+1]==1 && visited[tempX][tempY+1]!=1){
        		visited[tempX][tempY+1] = 1;
        		q.add(temp+1);
        	}
        	if(tempY-1>=0 && map[tempX][tempY-1]==1 && visited[tempX][tempY-1]!=1){
        		visited[tempX][tempY-1] = 1;
        		q.add(temp-1);
        	}
        }
    }
}
