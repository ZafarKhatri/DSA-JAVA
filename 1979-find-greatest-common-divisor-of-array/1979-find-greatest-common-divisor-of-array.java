class Solution {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        int min = nums[0];
        int max = nums[nums.length-1];
        int ans = gcd(min,max);
        return ans;
    }
    private int gcd(int a,int b){
        while(b!=0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}