class Solution {
    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n + 1];
        dp[0] = false;

        for (int i = 1; i <= n; i++) {
            if (isPerfectSquare(i)) {
                dp[i] = true;
            } else {
                for (int k = 1; k * k < i; k++) {
                    if (!dp[i - k * k]) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }

        return dp[n];
    }

    public static boolean isPerfectSquare(int n) {
        if (n < 0)
            return false;
        int root = (int) Math.sqrt(n);
        return (root * root) == n;
    }
}
