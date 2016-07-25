package day1.info;

public class NumArray {
    
    int[] tree;  // (partial) cumulative frequency array of size n + 1
    int[] numsCopy;  // a copy of the original array nums
    
    private void updateHelper(int idx, int diff) {
        while (idx <= numsCopy.length) {
            tree[idx] += diff;
            idx += (idx & -idx);
        }
    }
    
    private int cumulativeSum(int idx) {
        int sum = 0;
        while (idx > 0) {
            sum += tree[idx];
            idx -= (idx & -idx);
        }
        return sum;
    }

    public NumArray(int[] nums) {
        if (nums != null) {
            numsCopy = new int[nums.length];
            for (int i = 0; i < nums.length; ++i) numsCopy[i] = nums[i];
            tree = new int[nums.length + 1];  // partial cumulative sum (binary indexed)
            for (int i = 0; i < nums.length; ++i) updateHelper(i + 1, nums[i]);
        }
    }

    void update(int i, int val) {
        updateHelper(i + 1, val - numsCopy[i]);
        numsCopy[i] = val;
    }

    public int sumRange(int i, int j) {
        return cumulativeSum(j + 1) - cumulativeSum(i);
    }
    
    public static void main(String[] args) {
    	int[] a = {1,3,4,5,6,21,6};
    	NumArray na = new NumArray(a);
    	System.out.println(na.sumRange(0, 5));
	}
}