class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> result = new ArrayList<>();
        boolean[] contains = new boolean[101];

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int element : nums){
            min = Math.min(min,element);
            max = Math.max(max,element);
            contains[element] = true;
        }

        for(int i = min;i<=max;i++){
            if(!contains[i]){
                result.add(i);
            }
        }
        return result;
    }
}