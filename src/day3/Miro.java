package day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Miro {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		
		for(int i=0; i<N; ++i){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; ++j){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		
		br.close();
	}
}
