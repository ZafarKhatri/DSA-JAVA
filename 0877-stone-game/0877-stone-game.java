class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        Integer[][] dp = new Integer[n][n];

        int diff = solve(0, n - 1, piles, dp);

        return diff > 0;
    }

    public int solve(int left, int right, int[] nums, Integer[][] dp) {
        if (left == right)
            return nums[left];

        if (dp[left][right] != null)
            return dp[left][right];

        int takeleft = nums[left] - solve(left + 1, right, nums, dp);
        int takeright = nums[right] - solve(left, right - 1, nums, dp);

        int ans = Math.max(takeleft, takeright);

        dp[left][right] = ans;
        return ans;
    }
}