package day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberOrder {
	private static int MAX = 10000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] map = new int[MAX];
		
		for(int i=0; i<N; ++i){
			int temp = Integer.parseInt(br.readLine())-1;
			map[temp]++;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<MAX; ++i){
			for(int j=0; j<map[i]; ++j){
				sb.append(i+1).append("\n");
			}
		}
		System.out.println(sb.toString());
		br.close();
	}
}
