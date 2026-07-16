class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];//prefix GCD store karsu aa array ma 

        int max = nums[0];

        for (int i = 0; i < n; i++) {
            if (nums[i] >= max) {
                max = nums[i];
            }
            arr[i] = gcd(nums[i], max);
        }

        int m = arr.length;

        //prefix GCD array ne sort karsu aa step ma 
        Arrays.sort(arr);

        //pair banavi aapde
        long sum = 0;
        for (int i = 0; i < m / 2; i++) {
            int left = arr[i];
            int right = arr[m - 1 - i];
            sum += gcd(left, right);
        }
        return sum;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % temp;
            a = temp;
        }
        return a;
    }
}