package day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Miro {
	private static int[][] map = null;
	private static int N = 0;
	private static int M = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0; i<N; ++i){
			String row = br.readLine();
			for(int j=0; j<M; ++j){
				map[i][j] = Character.getNumericValue(row.charAt(j));
			}
		}
		System.out.println(bfs());
		
		br.close();
	}
	
	public static int bfs(){
		Queue<Integer> q = new ArrayDeque<>();
		map[0][0] = 2;
        q.add(0);
        
        while(!q.isEmpty()){
        	int temp = q.poll();
        	int tempX = temp/1000;
        	int tempY = temp%1000;
        	int depth = map[tempX][tempY];
        	if(tempX == N-1 && tempY == M-1){
        		break;
        	}
        	if(tempX+1<N && map[tempX+1][tempY]==1){
        		map[tempX+1][tempY] = depth+1;
        		q.add(temp+1000);
        	}
        	if(tempX-1>=0 && map[tempX-1][tempY]==1){
        		map[tempX-1][tempY] = depth+1;
        		q.add(temp-1000);
        	}
        	if(tempY+1<M && map[tempX][tempY+1]==1){
        		map[tempX][tempY+1] = depth+1;
        		q.add(temp+1);
        	}
        	if(tempY-1>=0 && map[tempX][tempY-1]==1){
        		map[tempX][tempY-1] = depth+1;
        		q.add(temp-1);
        	}
        }
        return map[N-1][M-1]-1;
    }
}
