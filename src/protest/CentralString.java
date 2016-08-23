package protest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import day4.PhoneNumberBook.Node;

public class CentralString {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; ++t){
			String A = br.readLine();
			String B = br.readLine();
			String C = br.readLine();
			
			Tree tree = new Tree();
			tree.add(A);
			tree.add(B);
			tree.add(C);
			
		}
		
		
		br.close();
	}
	
	public static class Tree{
		Node root = null;
		String cs = null;
		public Tree(){
			root = new Node('r');
		}
		public void add(String val){
			Node prev = root;
			for(char c : val.toCharArray()){
				if(!prev.children.containsKey(c)){
					prev.children.put(c, new Node(c));
				}
				prev = prev.children.get(c);
			}
		}
		
		public void getCentralString(){
			
		}
	}
	public static class Node{
		char val;
		Map<Character, Node> children = new HashMap<>();
		public Node(char val){
			this.val = val;
		}
	}
}

//[����]
//���ڿ����� ��ü ������ ���ڿ��� �� ���ڸ� �ٸ� ���ڷ� �ٲٴ� �����̴�. ���� ���, ���ڿ� ��computer������ 4��° ���� p�� m���� ��ü�ϸ� ��commuter���� �ȴ�.
//���� ������ �� ���ڿ� P�� Q�� �Ÿ� d(P,Q)�� P�� Q�� �ٲٱ� ���� ��ü ������ �ּ� ������ ���ǵȴ�. ���� ��� P = ��computers��, Q = ��consumers���� �ϸ�, P���� 3��° ���� m�� n����, 4��° ���� p�� s��, 6��° ���� t�� m���� �ٲٸ� Q�� �ȴ�. ���� P�� Q ������ �Ÿ��� 3�̴�.
//
//A, B, C�� ���� ������ ���ڿ��̶� ����. �� �� � ���ڿ� W�� �ݰ� r(W)�� ���ڿ� W�� ���ڿ� A, B, C���� �Ÿ� �� �ִ밪���� ���ǵȴ�. ��, r(W)= max{ d(W,A), d(W,B), d(W,C) } �̴�. ���� ���, A = ��computers��, B = ��consumers��, C = ��consensus���� ��, X = ��consunsrs���� �θ�, A, B, C�� X ������ �Ÿ��� d(X,A) = 4, d(X,B) = 2, d(X,C) = 2�̹Ƿ�, X�� �ݰ� r(X)�� 4�̴�. ���ڿ� A, B, C�� �߾ӹ��ڿ��� A, B, C���� �ݰ��� �ּҰ� �Ǵ� ���ڿ��� ���ǵȴ�. ���� ���, ���ڿ� A, B, C�� ���� ���� �־����� ��, Y = ��consuners���� �θ�, Y�� �ݰ��� 3�̰�, �ݰ��� 2�� ���ڿ��� �������� �����Ƿ�, Y�� A, B, C�� �߾ӹ��ڿ��� �ȴ�.
//
//
//
//
//���� �ҹ��ڵ�θ� ������ ���ڿ� A, B, C�� �־����� ��, �̵��� �߾ӹ��ڿ��� ���ϴ� ���α׷��� �ۼ��϶�.
//
//
//
//
//
//[�Է� ����]
//ù ��° �ٿ� �׽�Ʈ ���̽� ���� T�� �־�����, ���� 3 * T�ٿ� ���� T�� ���̽��� �Է°��� �־�����.
//�� ���̽��� 3�ٿ� ���� �Է°��� �־�����. 
//ù ��° �ٿ� ���ڿ� A�� �־�����.
//�� ��° �ٿ� ���ڿ� B�� �־�����.
//�� ��° �ٿ� ���ڿ� C�� �־�����.
//�� ���ڿ� A, B, C�� ���̴� �����ϰ�, �� ���̴� 1 �̻� 100,000 �����̴�.
//
//
//
//
//[��� ����]
//�� �׽�Ʈ ���̽��� ���� ������� ǥ��������� ����ϸ�, �� ���̽����� ���� ���ۿ� ��#x���� ����Ͽ��� �Ѵ�. �̶� x�� ���̽��� ��ȣ�̴�. 
//�������� ������ �ְ� �̾ A, B, C�� �߾� ���ڿ��� ������ �ݰ��� ����Ѵ�. �� ��, ã�� �߾� ���ڿ��� ����� �ʿ�� ����.
//
//
//
//
//[����� ����]
//�Է�
//1
//computers
//consumers
//consensus
//
//
//
//
//���
//#1 3
//
//
//
//
//[Tip]
//���� �Է� ������ �߾ӹ��ڿ��� 'consuners' �̰�, �� ���� �ݰ��� 3�̴�.