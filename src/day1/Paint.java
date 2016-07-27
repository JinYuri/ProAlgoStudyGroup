package day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Paint {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		Queue<Integer> woods = new LinkedList<>();
		
		st = new StringTokenizer(br.readLine());
		int[] rest = new int[N];
		int count = N/X;
		
		if(N%X>0){
			count+=1;
		}
		
		for(int i=0; i<N; ++i){
			woods.offer(Integer.parseInt(st.nextToken()));
		}
		
		while(!woods.isEmpty()){
		}
		
		br.close();
	}
}
