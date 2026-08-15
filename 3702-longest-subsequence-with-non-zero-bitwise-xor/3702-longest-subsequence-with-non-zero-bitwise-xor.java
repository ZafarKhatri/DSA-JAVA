class Solution { 
    public int longestSubsequence(int[] nums) { 
        int xorSum = 0;
        int size = nums.length; 
        boolean hasPositive = false; 

        for (int num : nums) { 
            hasPositive |= num > 0; 
            xorSum ^= num; 
        } 

        if (!hasPositive) {
            return 0; 
        }

        return xorSum == 0 ? size - 1 : size; 
    } 
}
