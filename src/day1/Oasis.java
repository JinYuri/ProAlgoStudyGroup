package day1;

import java.util.Scanner;
import java.util.Stack;

public class Oasis {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] line = new int[N];
		int[] answer = new int[N];
		
		for(int i=0; i<N; ++i){
			line[i] = sc.nextInt();
		}
		
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<N; ++i){
			if(!stack.isEmpty()){
				if(line[i] >= stack.peek()){
					answer[i] = stack.size();
					while(!stack.isEmpty() && stack.peek()<line[i]){
						stack.pop();
					}
				}
				else{
					answer[i]++;
				}
			}
			stack.push(line[i]);
		}
		int result = 0;
		for(int i=0; i<N; ++i){
			result += answer[i];
		}
		System.out.println(result);
		
		sc.close();
	}
}
