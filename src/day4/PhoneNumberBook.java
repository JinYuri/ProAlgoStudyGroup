package day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class PhoneNumberBook {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; ++t){
			int N = Integer.parseInt(br.readLine());
			Tree tree = new Tree();
			boolean isOk = true;
			for(int n=0; n<N; ++n){
				if(isOk){
					isOk = tree.add(br.readLine());
				}else{
					br.readLine();
				}
			}
			if(isOk) System.out.println("YES");
			else System.out.println("NO");
		}
		
		br.close();
	}
	
	public static class Tree{
		Node root = null;
		public Tree(){
			root = new Node('r');
		}
		public boolean add(String val){
			Node prev = root;
			for(char c : val.toCharArray()){
				if(prev.children.containsKey('E')){
					return false;
				}
				else if(!prev.children.containsKey(c)){
					prev.children.put(c, new Node(c));
				}
				prev = prev.children.get(c);
			}
			if(!prev.children.isEmpty()){
				return false;
			}
			prev.children.put('E', null);
			return true;
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
