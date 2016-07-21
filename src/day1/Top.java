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
		
		Stack<TopData> stack = new Stack<>();
		TopData send = new TopData(N, tops[N-1]);
		for(int i=N-2; i>=0; --i){
			TopData receive = new TopData(i+1, tops[i]);
			if(send.height <= receive.height){
				answers[send.index-1] = i+1;
				while(!stack.isEmpty()){
					send = stack.pop();
					if(send.height <= receive.height){
						answers[send.index-1] = i+1;
					}
				}
				send = receive;
			}
			else{
				stack.push(receive);
			}
		}
		
		while(!stack.isEmpty()){
			TopData temp = stack.pop();
			answers[temp.index-1] = 0;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<N; ++i){
			sb.append(answers[i]).append(" ");
		}
		
		System.out.println(sb.toString().trim());
		
		br.close();
	}
	public static class TopData{
		int index = Integer.MIN_VALUE;
		int height = Integer.MIN_VALUE;
		
		public TopData(int index, int height) {
			this.index = index;
			this.height = height;
		}
		
	}
}
