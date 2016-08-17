package protest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CentralString {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; ++t){
			String A = br.readLine();
			String B = br.readLine();
			String C = br.readLine();
		}
		
		br.close();
	}
}

//[문제]
//문자열에서 교체 연산은 문자열의 한 문자를 다른 문자로 바꾸는 연산이다. 예를 들어, 문자열 “computer”에서 4번째 문자 p를 m으로 교체하면 “commuter”가 된다.
//같은 길이의 두 문자열 P와 Q의 거리 d(P,Q)는 P를 Q로 바꾸기 위한 교체 연산의 최소 개수로 정의된다. 예를 들어 P = “computers”, Q = “consumers”라 하면, P에서 3번째 문자 m을 n으로, 4번째 문자 p를 s로, 6번째 문자 t를 m으로 바꾸면 Q가 된다. 따라서 P와 Q 사이의 거리는 3이다.
//
//A, B, C를 같은 길이의 문자열이라 하자. 이 때 어떤 문자열 W의 반경 r(W)는 문자열 W와 문자열 A, B, C와의 거리 중 최대값으로 정의된다. 즉, r(W)= max{ d(W,A), d(W,B), d(W,C) } 이다. 예를 들어, A = “computers”, B = “consumers”, C = “consensus”일 때, X = “consunsrs”라 두면, A, B, C와 X 사이의 거리는 d(X,A) = 4, d(X,B) = 2, d(X,C) = 2이므로, X의 반경 r(X)는 4이다. 문자열 A, B, C의 중앙문자열은 A, B, C와의 반경이 최소가 되는 문자열로 정의된다. 예를 들어, 문자열 A, B, C가 위와 같이 주어졌을 때, Y = “consuners”라 두면, Y의 반경은 3이고, 반경이 2인 문자열은 존재하지 않으므로, Y는 A, B, C의 중앙문자열이 된다.
//
//
//
//
//영어 소문자들로만 구성된 문자열 A, B, C가 주어졌을 때, 이들의 중앙문자열을 구하는 프로그램을 작성하라.
//
//
//
//
//
//[입력 형식]
//첫 번째 줄에 테스트 케이스 수인 T가 주어지고, 다음 3 * T줄에 걸쳐 T개 케이스의 입력값이 주어진다.
//각 케이스는 3줄에 걸쳐 입력값이 주어진다. 
//첫 번째 줄에 문자열 A가 주어진다.
//두 번째 줄에 문자열 B가 주어진다.
//세 번째 줄에 문자열 C가 주어진다.
//세 문자열 A, B, C의 길이는 동일하고, 그 길이는 1 이상 100,000 이하이다.
//
//
//
//
//[출력 형식]
//각 테스트 케이스의 답을 순서대로 표준출력으로 출력하며, 각 케이스마다 줄의 시작에 “#x”를 출력하여야 한다. 이때 x는 케이스의 번호이다. 
//공백으로 구분을 주고 이어서 A, B, C의 중앙 문자열이 가지는 반경을 출력한다. 이 때, 찾은 중앙 문자열을 출력할 필요는 없다.
//
//
//
//
//[입출력 예제]
//입력
//1
//computers
//consumers
//consensus
//
//
//
//
//출력
//#1 3
//
//
//
//
//[Tip]
//위의 입력 예제의 중앙문자열은 'consuners' 이고, 이 때의 반경은 3이다.
