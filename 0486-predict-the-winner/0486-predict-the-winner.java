class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;

        int left = 0;
        int right = n - 1;

        Integer[][] dp = new Integer[n][n];

        int diff = solve(left, right, nums, dp);
        
        return diff >= 0;
    }

    private int solve(int left, int right, int[] nums, Integer[][] dp) {

        if (left == right) {
            return nums[left];
        }
        if (dp[left][right] != null) {
            return dp[left][right];
        }

        int takeleft = nums[left] - solve(left + 1, right, nums, dp);
        int takeright = nums[right] - solve(left, right - 1, nums, dp);

        int ans = Math.max(takeleft, takeright);

        dp[left][right] = ans;

        return ans;
    }
}