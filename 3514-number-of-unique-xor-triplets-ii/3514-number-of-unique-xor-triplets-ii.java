class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;

        int[] pair_xor = new int[2048];
        int[] triple_xor = new int[2048];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                pair_xor[nums[i] ^ nums[j]] = 1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2048; j++) {
                if (pair_xor[j] == 1) {
                    triple_xor[j ^ nums[i]] = 1;
                }
            }
        }

        int count = 0;
        for (int value : triple_xor) {
            if (value == 1)
                count++;
        }
        return count;
    }
}