package day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Movie {
	private static int[] array = null;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for(int t=0; t<T; ++t){
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			array = new int[N+1];
			for(int i=1; i<=N; ++i){
				update(i, i);
			}
			
			st = new StringTokenizer(br.readLine());
			int[] answer = new int[M];
			
			for(int i=0; i<M; ++i){
				int temp = Integer.parseInt(st.nextToken());
				answer[i] = rsq(1, temp);
				update(1, temp);
			}
			
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<M; ++i){
				sb.append(answer[i]).append(" ");
			}
			
			System.out.println(sb.toString().trim());
		}
		
		
		br.close();
	}
	
    public static int rsq(int ind, int i) {
        int sum = 0;
        while (ind > 0) {
            sum += array[ind];
            ind -= ind & (-ind);
        }

        return sum;
    }
    public static void update(int ind, int value) {
        while (ind < array.length) {
            array[ind] += value;
            ind += ind & (-ind);
        }
    }

}
