

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	// ���� x, y ��ǥ�� ����
	private static int[][] dots = null;
	// ���� ���� ������� ���� ���� (0:����, 1:���)
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
		// Test Case ����ŭ Loop
		for(int t=1; t<=T; ++t){
			// Input �ޱ�!
			N = Integer.parseInt(br.readLine());
			dots = new int[N][2];
			for(int n=0; n<N; ++n){
				st = new StringTokenizer(br.readLine());
				dots[n][0] = Integer.parseInt(st.nextToken());
				dots[n][1] = Integer.parseInt(st.nextToken());
			}
			
			// �������� ������ ��ǥ
			int x1 = dots[0][0];
			int y1 = dots[0][1];
			int xn = dots[N-1][0];
			int yn = dots[N-1][1];
			
			// ����� �� (���� ��)
			// ������ -> �������� �� �� ���ٸ� ������ -1�̸� �̿ܿ� -1�� ���� ����
			int count = -1;
			
			// ������ -> �������� �� �� �ִ� ���
			if(x1 < xn && y1 < yn){
				check = new int[N];
				mem = new int[N];
				// DP�� ������ �� ���ܴ�� ���� üũ
				// ������, ������ ����
				for(int n=1; n<N-1; ++n)
					if(x1 < dots[n][0] && y1 < dots[n][1] && dots[n][0] < xn && dots[n][1] < yn)
						check[n] = 1;
				
				// DP ����
				// 1�� �� -> N�� ������ ���� ���� ������ 1�� ������
				count = (1+getCount(0)) % D;
			}
			// #1 1 �������� ������� String ����
			sb.append("#").append(t).append(" ").append(count).append("\n");
		}
		// ��� ���
		System.out.println(sb.toString());
		br.close();
	}
	// idx �� -> N������ ���� ����� ��
	private static int getCount(int idx){
		int result = 0;
		// memoization�� ���� ������ �ٷ� return
		if(mem[idx] != 0)
			return mem[idx];
		else{
			for(int i=1; i<N; ++i){
				// ���� ����� �ƴϰ� ���� idx���� ���� �ִ� ���̸� �̵�
				if(check[i]==1 && dots[idx][0] < dots[i][0] && dots[idx][1] < dots[i][1])
					// (���ݱ��� ������ result) + (idx�� -> i�� -> N���� ���� ����� �� 1��) + (i�� -> N������ ���� ����� ��)
					result = (result + 1 + getCount(i)) % D;
			}
		}
		// memoization �߰�
		mem[idx] = result; 
		return result;
	}
}
