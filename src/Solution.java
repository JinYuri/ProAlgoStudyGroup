

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	// 점의 x, y 좌표값 저장
	private static int[][] dots = null;
	// 점이 제외 대상인지 여부 저장 (0:제외, 1:대상)
	private static int[] check = null;
	// Memoization
	private static int[] mem = null;
	private static int N = 0;
	private static int D = 100000007;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		// Test Case 수만큼 Loop
		for(int t=1; t<=T; ++t){
			// Input 받기!
			N = Integer.parseInt(br.readLine());
			dots = new int[N][2];
			for(int n=0; n<N; ++n){
				st = new StringTokenizer(br.readLine());
				dots[n][0] = Integer.parseInt(st.nextToken());
				dots[n][1] = Integer.parseInt(st.nextToken());
			}
			
			// 시작점과 끝점의 좌표
			int x1 = dots[0][0];
			int y1 = dots[0][1];
			int xn = dots[N-1][0];
			int yn = dots[N-1][1];
			
			// 경우의 수 (최종 답)
			// 시작점 -> 끝점으로 갈 수 없다면 무조건 -1이며 이외에 -1인 경우는 없음
			int count = -1;
			
			// 시작점 -> 끝점으로 갈 수 있는 경우
			if(x1 < xn && y1 < yn){
				check = new int[N];
				mem = new int[N];
				// DP를 돌리기 전 제외대상 여부 체크
				// 시작점, 끝점은 제외
				for(int n=1; n<N-1; ++n)
					if(x1 < dots[n][0] && y1 < dots[n][1] && dots[n][0] < xn && dots[n][1] < yn)
						check[n] = 1;
				
				// DP 수행
				// 1번 점 -> N번 점으로 가는 길이 있으니 1을 더해줌
				count = (1+getCount(0)) % D;
			}
			// #1 1 형식으로 출력위해 String 생성
			sb.append("#").append(t).append(" ").append(count).append("\n");
		}
		// 결과 출력
		System.out.println(sb.toString());
		br.close();
	}
	// idx 점 -> N점으로 가는 경우의 수
	private static int getCount(int idx){
		int result = 0;
		// memoization에 값이 있으면 바로 return
		if(mem[idx] != 0)
			return mem[idx];
		else{
			for(int i=1; i<N; ++i){
				// 제외 대상이 아니고 현재 idx에서 갈수 있는 점이면 이동
				if(check[i]==1 && dots[idx][0] < dots[i][0] && dots[idx][1] < dots[i][1])
					// (지금까지 구해진 result) + (idx점 -> i점 -> N으로 가는 경우의 수 1개) + (i점 -> N점으로 가는 경우의 수)
					result = (result + 1 + getCount(i)) % D;
			}
		}
		// memoization 추가
		mem[idx] = result; 
		return result;
	}
}
