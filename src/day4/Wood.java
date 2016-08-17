package day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Wood {
	private static int[] WOODS = null;
	private static int M = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		WOODS = new int[N];
		int maxH = Integer.MIN_VALUE;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; ++i){
			WOODS[i] = Integer.parseInt(st.nextToken());
			maxH = Math.max(maxH, WOODS[i]);
		}
		
		System.out.println(binarySearch(1, maxH));
		br.close();
	}
	
	private static int binarySearch(int bottom, int top){
		int mid = (top+bottom)/2;
		long total = getH(mid);
		if(total == M || bottom == top){
			return mid;
		}
		else if(bottom == top-1){
			if(getH(top) > M) return top;
			else return mid;
		}
		else if(total > M){
			return binarySearch(mid, top);
		}
		else{
			return binarySearch(bottom, mid-1);
		}
	}
	private static long getH(int h){
		long sum = 0;
		for(int i=0; i<WOODS.length; ++i){
			if(WOODS[i] > h){
				sum+=WOODS[i]-h;
			}
		}
		return sum;
	}
}
