package day1;

import java.util.Scanner;
import java.util.Stack;

public class Oasis {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] line = new int[N];
		long result = 0;
		
		for(int i=0; i<N; ++i){
			line[i] = sc.nextInt();
		}
		
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> wStack = new Stack<>();
		
		for(int i=0; i<N; ++i){
			int weight = 1;
			if(!stack.isEmpty()){
				int count = 0;
				while(!stack.isEmpty() && stack.peek()<line[i]){
					stack.pop();
					wStack.pop();
					count++;
				}
				if(!stack.isEmpty()){
					if(line[i] == stack.peek()) {
						weight = wStack.peek()+1;
						count += wStack.peek();
						
						if(stack.size() > wStack.peek()) {
							count ++;
						}
					}
					else {
						count ++;
					}
				}
				result += count;
			}
			stack.push(line[i]);
			wStack.push(weight);
		}
		
		System.out.println(result);
		
		sc.close();
	}
}
