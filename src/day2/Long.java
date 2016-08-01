package day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Long {
	private static int N = 0;
	private static int[] NUMS = null;
	private static int[] ANSWER = null;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		NUMS = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		NUMS[0] = Integer.MAX_VALUE;
		for(int i=1; i<=N; ++i){
			NUMS[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(getMaxDist(0, 1));
		br.close();
	}
	
	private static int getMaxDist(int std, int tmp){
		int result = 0;
		
		if(tmp == N+1){
			result = 0;
		}
		else {
			if(NUMS[std] < NUMS[tmp]){
				result = Math.max(getMaxDist(tmp, tmp+1)+1, getMaxDist(std, tmp+1));
			}else{
				result = Math.max(getMaxDist(tmp, tmp+1), getMaxDist(std, tmp+1));
			}
		}
		
		return result;
	}
}
