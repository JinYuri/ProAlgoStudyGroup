package day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Movie {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for(int t=0; t<T; ++t){
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int[] toWatch = new int[M];
			int[] answer = new int[M];
			
			for(int i=0; i<M; ++i){
				toWatch[i] = Integer.parseInt(st.nextToken());
			}
			
			
			
			
			
			
			
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<M; ++i){
				sb.append(answer[i]).append(" ");
			}
			
			System.out.println(sb.toString().trim());
		}
		
		
		br.close();
	}
}
