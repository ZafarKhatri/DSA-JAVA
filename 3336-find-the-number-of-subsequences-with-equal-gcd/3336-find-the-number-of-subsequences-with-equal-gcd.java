class Solution {
    int MOD = 1_000_000_007;

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public int subsequencePairCount(int[] nums) {
        int n = nums.length;
        int maxEl = -1;
        for (int x : nums)
            maxEl = Math.max(maxEl, x);

        int[][] prev = new int[maxEl + 1][maxEl + 1];

        for (int first = maxEl; first >= 0; first--) {
            for (int second = maxEl; second >= 0; second--) {
                boolean bothNonEmpty = (first != 0 && second != 0);
                boolean gcdsMatch = (first == second);
                prev[first][second] = (bothNonEmpty && gcdsMatch) ? 1 : 0;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            int[][] curr = new int[maxEl + 1][maxEl + 1];
            for (int first = maxEl; first >= 0; first--) {
                for (int second = maxEl; second >= 0; second--) {
                    int skip = prev[first][second];
                    int take1 = prev[gcd(first, nums[i])][second];
                    int take2 = prev[first][gcd(second, nums[i])];
                    curr[first][second] = (int) ((0L + skip + take1 + take2) % MOD);
                }
            }
            prev = curr;
        }

        return prev[0][0];
    }
}
