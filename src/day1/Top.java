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
		int sVal = tops[N-1];
		int sIdx = N;
		for(int i=N-2; i>=0; --i){
			int rVal = tops[i];
			int rIdx = i+1;
			if(sVal <= rVal){
				answers[sIdx-1] = i+1;
				while(!valStack.isEmpty()){
					sVal = valStack.pop();
					sIdx = idxStack.pop();
					if(sVal <= rVal){
						answers[sIdx-1] = i+1;
					}
				}
				sVal = rVal;
				sIdx = rIdx;			}
			else{
				valStack.push(rVal);
				idxStack.push(rIdx);
			}
		}
		
		while(!idxStack.isEmpty()){
			answers[idxStack.pop()-1] = 0;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<N; ++i){
			sb.append(answers[i]).append(" ");
		}
		
		System.out.println(sb.toString().trim());
		
		br.close();
	}
}
