class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] ans = new int[m][n];
        List<List<Integer>> res = new ArrayList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int Index = i * n + j;
                int newIndex = (Index + k)% (m*n);
                int newCol = newIndex % n;
                int newRow = newIndex / n;
                ans[newRow][newCol] = grid[i][j];
            }
        } 

        for(int i =0;i<ans.length;i++){
            List<Integer> row = new ArrayList<>();
            for(int j=0;j<n;j++){
                row.add(ans[i][j]);   
            }
            res.add(row);
        }
        return res;   
    }
}