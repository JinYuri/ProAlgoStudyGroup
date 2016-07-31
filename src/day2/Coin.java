package day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Coin {
	private static int N = 0;
	private static int K = 0;
	private static int COUNT = 0;
	private static int[] COINS = null;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		COINS = new int[N];
		for(int i=0; i<N; ++i){
			COINS[i] = Integer.parseInt(br.readLine());
		}
		
		getCase(0, K);
		System.out.println(COUNT);
		br.close();
	}
	
	private static void getCase(int idx, int rest){
		
		if(rest==0){
			COUNT++;
			return;
		}
		
		if(idx == N)
			return;
		
		if(rest < COINS[idx])
			getCase(idx+1, rest);
		
		int maxCount = rest/COINS[idx];
		for(int i=0; i<=maxCount; ++i){
			getCase(idx+1, rest-(i*COINS[idx]));
		}
	}
}
