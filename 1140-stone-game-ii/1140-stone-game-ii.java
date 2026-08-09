class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        Integer[][] dp = new Integer[n][n + 1];

        return solve(0, 1, piles, dp);
    }

    public int solve(int i, int M, int[] piles, Integer[][] dp) {
        if (i >= piles.length) {
            return 0;
        }

        if (dp[i][M] != null) {
            return dp[i][M];
        }

        int total = 0;
        int best = 0;

        for (int x = 1; x <= 2 * M && i + x <= piles.length; x++) {
            total += piles[i + x - 1];

            int opponent = solve(
                i + x,
                Math.max(M, x),
                piles,
                dp
            );

            int current = total + remainingPiles(i + x, piles) - opponent;

            best = Math.max(best, current);
        }

        return dp[i][M] = best;
    }

    public int remainingPiles(int i, int[] piles) {
        int sum = 0;

        for (int j = i; j < piles.length; j++) {
            sum += piles[j];
        }

        return sum;
    }
}