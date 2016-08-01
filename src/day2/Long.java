package day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Long {
	private static int N = 0;
	private static int[] NUMS = null;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		NUMS = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			NUMS[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(getMaxDist(N));
		br.close();
	}

	private static int getMaxDist(int size) {
		int[] answer = new int[size];
		int len = 1;
		for (int i = 1; i < size; i++) {
			if (NUMS[i] < answer[0])
				answer[0] = NUMS[i];
			else if (NUMS[i] > answer[len - 1])
				answer[len++] = NUMS[i];
			else
				answer[getIdx(answer, -1, len - 1, NUMS[i])] = NUMS[i];
		}
		return len;
	}

	private static int getIdx(int[] answer, int l, int r, int key) {
		while (r - l > 1)
        {
            int m = l + (r - l)/2;
            if (answer[m]>=key)
                r = m;
            else
                l = m;
        }
 
        return r;
	}
}
// 7
// 10 100 120 20 30 40 50

//http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/