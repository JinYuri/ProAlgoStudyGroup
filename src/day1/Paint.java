package day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Paint {
	private static ArrayDeque<Integer> woods = new ArrayDeque<>();
	private static int X = 0;
	private static int N = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		
		st = new StringTokenizer(br.readLine());
		int count = 0;
		int min = Integer.MAX_VALUE;
		for(int i=0; i<N; ++i){
			int temp = Integer.parseInt(st.nextToken());
			woods.add(temp);
			min = Math.min(min, temp);
		}
		
		br.close();
	}
}
