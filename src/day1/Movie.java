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
			
			int height = (int)(Math.ceil(Math.log(N+M) /  Math.log(2)));
	        int maxsize = (int) Math.pow(2, height) + 1;


	        array = new int[maxsize];

			int[] indexArr = new int[N];
			for(int i=1; i<=M; ++i){
				update(i, 0);
				
			}
			for(int i=M+1; i<=N+M; ++i){
				update(i, 1);
				indexArr[i-M-1] = i;
			}
			
			st = new StringTokenizer(br.readLine());
			int[] answer = new int[M];
			
			for(int i=0; i<M; ++i){
				int temp = Integer.parseInt(st.nextToken());
				answer[i] = rsq(M-i+1, indexArr[temp-1]-1);
				update(indexArr[temp-1], -1);
				update(M-i, 1);
				indexArr[temp-1] = M-i;
			}
			
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<M; ++i){
				sb.append(answer[i]).append(" ");
				
			}
			
			System.out.println(sb.toString().trim());
		}
		
		
		br.close();
	}
	
	public static int rsq(int ind) {
        int sum = 0;
        while (ind > 0) {
            sum += array[ind];
            ind -= ind & (-ind);
        }

        return sum;
    }

    public static int rsq(int a, int b) {
        return rsq(b) - rsq(a - 1);
    }
    public static void update(int ind, int value) {
        while (ind < array.length) {
            array[ind] += value;
            ind += ind & (-ind);
        }
    }

}
