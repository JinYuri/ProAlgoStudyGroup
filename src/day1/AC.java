package day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AC {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		char[] commands = null;
		StringTokenizer arrays = null;
		for(int i=0; i<T; ++i){
			commands = br.readLine().toCharArray();
			int N = Integer.parseInt(br.readLine());
			String arrayInput = br.readLine();
			arrays = new StringTokenizer(arrayInput.substring(1, arrayInput.length()-1), ",");
			
			String[] queue = new String[N];
			int head = 0;
			int tail = N-1;
			boolean reverse = false;
			boolean isError = false;
			
			for(int j=0; j<N; ++j){
				queue[j] = arrays.nextToken();
			}
			
			for(char cmd : commands){
				if('R' == cmd){
					reverse = !reverse;
				} 
				else if('D' == cmd){
					if(head > tail){
						isError = true;
						break;
					}
					if(reverse){
						tail --;
					}
					else{
						head ++;
					}
				}
			}
			
			if(isError){
				System.out.println("error");
			}
			else{
				StringBuilder sb = new StringBuilder();
				sb.append("[");
				if(reverse){
					for(int j=tail; j>=head; --j){
						if(j == head){
							sb.append(queue[j]);
						}
						else{
							sb.append(queue[j]).append(",");
						}
					}
				}else{
					for(int j=head; j<=tail; ++j){
						if(j == tail){
							sb.append(queue[j]);
						}
						else{
							sb.append(queue[j]).append(",");
						}
					}
				}
				sb.append("]");
				
				System.out.println(sb.toString());
			}
		}
		
	}
}
