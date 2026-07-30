class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int rows= mat.length;
        int cols = mat[0].length;
        if(rows*cols!=r*c){
            return mat;
        }
        int[][] ans = new int[r][c];
        int row = 0;
        int col = 0;
        for(int i =0;i<rows;i++){
            for(int j =0;j<cols;j++){
                ans[row][col]= mat[i][j];
                col++;
                if(col==c){
                    col=0;
                    row++;
                }
            }
        }
        return ans;
    }
}