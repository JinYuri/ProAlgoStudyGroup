package day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Fraction {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int c1 = Integer.parseInt(st.nextToken());
		int p1 = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int c2 = Integer.parseInt(st.nextToken());
		int p2 = Integer.parseInt(st.nextToken());
		
		int rp = getLcm(p1, p2);
		int rc = c1*(rp/p1) + c2*(rp/p2);
		
		int gcd = getGcd(rp, rc);
		
		System.out.println(rc/gcd + " " + rp/gcd);
		
		br.close();
	}
	//최대공약수
	private static int getGcd(int a, int b){
		while(b != 0){
			int temp =  a % b;
			a = b;
			b = temp;
		}
		return Math.abs(a);
	}
	//최소공배수
	private static int getLcm(int a, int b){
		int gcd = getGcd(a,b);
		if(gcd == 0){
			return 0;
		}
		return Math.abs((a*b)/gcd);
	}
}
