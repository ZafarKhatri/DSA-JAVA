class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] temp_arr=arr.clone();
        int n=temp_arr.length;

        Arrays.sort(temp_arr);

        HashMap<Integer,Integer> hm =new HashMap<>();

        for(int i=0;i<n;i++){
            int temp_val= temp_arr[i];
            hm.putIfAbsent(temp_val,hm.size()+1);
        }

        for(int i=0;i<n;i++){
            arr[i]=hm.get(arr[i]);
        }
        
        return arr;
    }
}