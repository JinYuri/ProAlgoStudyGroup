package day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NumberTriangle {
	private static int N = 0;
	private static int[][] TRIANGLE = null;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		TRIANGLE = new int[N][N+1];
		
		for(int i=0; i<N; ++i){
			st = new StringTokenizer(br.readLine());
			int j=0;
			while(st.hasMoreTokens()){
				TRIANGLE[i][j++]= Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(getMaxSum(0, 0));
		br.close();
	}
	
	private static int getMaxSum(int i, int j){
		int result = 0;
		if(i < N && j < i+1){
			if(TRIANGLE[N-1-i][N-j] != 0){
				return TRIANGLE[N-1-i][N-j];
			}else{
				result = TRIANGLE[i][j] + Math.max(getMaxSum(i+1, j), getMaxSum(i+1, j+1));
			}
			TRIANGLE[N-1-i][N-j] = result;
		}
		return result;
	}
}
