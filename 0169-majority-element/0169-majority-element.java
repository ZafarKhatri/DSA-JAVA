class Solution {
    public int majorityElement(int[] nums) {
        int ans = 0;//answer
        int freq = 0;//frequency
        int n = nums.length;

        for(int i=0;i<n;i++){
            if(freq==0) ans=nums[i];
            if(nums[i]==ans) freq++;
            else freq--;
        }
        return ans;
    }
}