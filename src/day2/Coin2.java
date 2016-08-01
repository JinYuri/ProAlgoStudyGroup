package day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Coin2 {
	private static int N = 0;
	private static int K = 0;
	private static int[] COINS = null;
	private static int[][] MEM = null;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		MEM = new int[N+1][K+1];
		COINS = new int[N];
		for(int i=0; i<N; ++i){
			COINS[i] = Integer.parseInt(br.readLine());
		}
		for(int i=0; i<=N; ++i){
			for(int j=0; j<=K; ++j){
				MEM[i][j] = -2;
			}
		}
		System.out.println(getMinCount(0, K));
		br.close();
	}
	
	private static int getMinCount(int idx, int rest){
		int result = Integer.MAX_VALUE;
		if(rest==0){
			result = 0;
		}
		else if(idx == N){
			result = -1;
		}
		else if(-2 != MEM[idx][rest]){
			return MEM[idx][rest];
		}
		else if(rest < COINS[idx]){
			result = getMinCount(idx+1, rest);
		}
		else{
			int maxCount = rest/COINS[idx];
			for(int i=0; i<=maxCount; ++i){
				int temp = getMinCount(idx+1, rest-(i*COINS[idx]));
				if(temp>=0)
					result = Math.min(result, temp+i);
			}
		}
		
		if(result == Integer.MAX_VALUE){
			result = -1;
		}
		MEM[idx][rest] = result;
		return result;
	}
}
