class Solution {
    public void setZeroes(int[][] matrix) {
        ArrayList<Integer>row = new ArrayList<>();
        ArrayList<Integer>col = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;

        for(int i = 0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    row.add(i);
                    col.add(j);
                }
            }
        }
        for(int i=0;i<row.size();i++){
            int index =row.get(i);
            for (int j=0;j<m;j++){
                matrix[index][j]=0;
            }
        }
        for(int i=0;i<col.size();i++){
            int index=col.get(i);
            for(int j =0;j<n;j++){
                matrix[j][index]=0;
            }
        }
    }
}