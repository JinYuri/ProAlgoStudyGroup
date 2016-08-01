package day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class OneMaker {
	private static Map<Integer, Integer> MEM = new HashMap<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(getMinCount(n));
		br.close();
	}
	private static int getMinCount(int num) {
		int result = Integer.MAX_VALUE;
		
		if(MEM.containsKey(num)){
			return MEM.get(num);
		}
		else if(num == 1){
			result = 0;
		}
		else {
			if(num/2 >0 && num % 2 == 0)
				result = Math.min(result, getMinCount(num/2));
			if(num/3 >0 && num % 3 == 0)
				result = Math.min(result, getMinCount(num/3));
			
			result = Math.min(result, getMinCount(num-1));
			result ++;
		}
		MEM.put(num, result);
		return result;
	}
}
