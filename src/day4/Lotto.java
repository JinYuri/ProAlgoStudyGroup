package day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lotto {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int cr = 0;
		for(int i=K; i<=M; ++i){
			cr+= (combination(M, i)*combination(N-M, M-i));
		}
		double result = (double)cr/(double)combination(N, M);
		System.out.printf("%.10f", result);
		br.close();
	}
	// 배열하나 만들어서 caching하는게 나음, 안함 20이상은 stack overflow
	public static int combination(int n, int r) {
		if(n == 0) return 0;
		if(n == r || r == 0) return 1;
		else return combination(n - 1, r - 1) + combination(n - 1, r);
		
	}
}
