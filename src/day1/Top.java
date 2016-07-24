package day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Top {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] tops = new int[N];
		int[] answers = new int[N];
		
		
		for(int i=0; i<N; ++i){
			tops[i] = Integer.parseInt(st.nextToken());
		}
		
		Stack<Integer> valStack = new Stack<>();
		Stack<Integer> idxStack = new Stack<>();

		for(int i=N-1; i>=0; --i){
			while(!valStack.isEmpty() && tops[i] >= valStack.peek()){
				valStack.pop();
				answers[idxStack.pop()] = i+1;
			}
			valStack.push(tops[i]);
			idxStack.push(i);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; ++i){
			sb.append(answers[i]).append(" ");
		}
		System.out.println(sb.toString().trim());
		
		br.close();
	}
}
