class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        System.gc();
        int n = nums.length;
        int option1 = nums[n - 3] * nums[n - 1] * nums[n - 2];
        int option2 = nums[0] * nums[1] * nums[n - 1];

        return Math.max(option1, option2);
    }
}
