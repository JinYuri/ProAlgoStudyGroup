package day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MinMax {
	private static int[] MAX_TREE;
	private static int[] MIN_TREE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int height = (int)(Math.ceil(Math.log(N) /  Math.log(2)));
        int maxsize = 2 * (int) Math.pow(2, height) - 1;
        MAX_TREE = new int[maxsize];
        MIN_TREE = new int[maxsize];
        
        for(int i=0; i<maxsize; ++i){
        	MAX_TREE[i] = Integer.MIN_VALUE;
        	MIN_TREE[i] = Integer.MAX_VALUE;
        }
		int[] input = new int[N];
		
		for(int i=0; i<N; ++i){
			input[i]=Integer.parseInt(br.readLine());
		}
		
		constructMax(input,0,N-1,0);
		constructMin(input,0,N-1,0);
		
		for(int i=0; i<M; ++i){
			st = new StringTokenizer(br.readLine());
			int queryStart = Integer.parseInt(st.nextToken())-1;
			int queryEnd = Integer.parseInt(st.nextToken())-1;
			System.out.println(getMin(0, N-1, queryStart, queryEnd, 0)+" " +getMax(0, N-1, queryStart, queryEnd, 0));
		}
		
		br.close();
	}
	private static int constructMax(int[] elements, int startIndex, int endIndex, int current)
	{
		if (startIndex == endIndex)
		{
			MAX_TREE[current] = elements[startIndex];
			return MAX_TREE[current];	
		}
		int mid = mid(startIndex, endIndex);
		MAX_TREE[current] = Math.max(constructMax(elements, startIndex, mid, leftchild(current))
				, constructMax(elements, mid + 1, endIndex, rightchild(current)));
		return MAX_TREE[current];
	}
	
	private static int constructMin(int[] elements, int startIndex, int endIndex, int current)
	{
		if (startIndex == endIndex)
		{
			MIN_TREE[current] = elements[startIndex];
			return MIN_TREE[current];	
		}
		int mid = mid(startIndex, endIndex);
		MIN_TREE[current] = Math.min(constructMin(elements, startIndex, mid, leftchild(current))
				, constructMin(elements, mid + 1, endIndex, rightchild(current)));
		return MIN_TREE[current];
	}
	private static int mid(int start, int end)
    {
        return (start + (end - start) / 2); 
    }
	private static int leftchild(int pos) {
		return 2 * pos + 1;
	}

	private static int rightchild(int pos) {
		return 2 * pos + 2;
	}
	
    private static int getMax(int startIndex, int endIndex, int queryStart, int queryEnd, int current)
    {
        if (queryStart <= startIndex && queryEnd >= endIndex )
        {
            return MAX_TREE[current];
        }
        if (endIndex < queryStart || startIndex > queryEnd)
        {
            return Integer.MIN_VALUE;
        }
        int mid = mid(startIndex, endIndex);
        return  Math.max(getMax(startIndex, mid, queryStart, queryEnd, leftchild(current)) 
                 ,getMax( mid + 1, endIndex, queryStart, queryEnd, rightchild(current)));
    }
    private static int getMin(int startIndex, int endIndex, int queryStart, int queryEnd, int current)
    {
        if (queryStart <= startIndex && queryEnd >= endIndex )
        {
            return MIN_TREE[current];
        }
        if (endIndex < queryStart || startIndex > queryEnd)
        {
            return Integer.MAX_VALUE;
        }
        int mid = mid(startIndex, endIndex);
        return  Math.min(getMin(startIndex, mid, queryStart, queryEnd, leftchild(current)) 
                 ,getMin( mid + 1, endIndex, queryStart, queryEnd, rightchild(current)));
    }
}
