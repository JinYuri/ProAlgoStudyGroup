package day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Coin {
	private static int N = 0;
	private static int K = 0;
	private static int[] COINS = null;
	private static int GAP = 1000;
	private static Map<Integer, Integer> mem = new HashMap<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		COINS = new int[N];
		for(int i=0; i<N; ++i){
			COINS[i] = Integer.parseInt(br.readLine());
		}
		
		System.out.println(getCase(0, K));
		br.close();
	}
	
	private static int getCase(int idx, int rest){
		int result = 0;
		int key = rest*GAP+idx;
		if(mem.containsKey(key)){
			return mem.get(key);
		}
		else if(rest==0){
			result = 1;
		}
		else if(idx == N){
			result = -1;
		}
		else if(rest < COINS[idx]){
			result = getCase(idx+1, rest);
		}
		else{
			int maxCount = rest/COINS[idx];
			for(int i=0; i<=maxCount; ++i){
				int temp = getCase(idx+1, rest-(i*COINS[idx]));
				if(temp>0)
					result+=temp;
			}
		}
		mem.put(rest*GAP+idx, result);
		return result;
	}
}
