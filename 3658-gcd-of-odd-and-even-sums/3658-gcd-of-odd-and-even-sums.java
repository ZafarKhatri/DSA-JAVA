import java.math.BigInteger;
class Solution {
    public int gcdOfOddEvenSums(int n) {
        int evenSum=(n+1)*n;
        int oddSum =n*n;
        return getGCD(evenSum,oddSum);
    }
    private int getGCD(int a, int b) {
        return b == 0 ? a : getGCD(b, a % b);
    }
}