class Solution {
    public long sumAndMultiply(int n) {
        long actualnumber = 0;
        long sum = 0;
        long multipler = 1;

        while (n > 0) {
            int digit = n % 10;
            if (digit != 0) {
                sum += digit;
                actualnumber = digit * multipler + actualnumber;
                multipler *= 10;
            }
            n /= 10;
        }
        return actualnumber * sum;
    }
}