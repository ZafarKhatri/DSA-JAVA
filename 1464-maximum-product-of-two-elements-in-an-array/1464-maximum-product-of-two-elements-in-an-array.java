class Solution {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length-1;
        int largest = nums[n];
        int secondlargest = nums[n-1];

        return((largest-1)*(secondlargest-1));
        
    }
}