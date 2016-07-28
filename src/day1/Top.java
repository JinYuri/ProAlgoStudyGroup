package day1;

import java.util.Scanner;
import java.util.Stack;

public class Top {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] tops = new int[N];
		int[] answers = new int[N];
		
		
		for(int i=0; i<N; ++i){
			tops[i] = sc.nextInt();
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
		
		sc.close();
	}
}
