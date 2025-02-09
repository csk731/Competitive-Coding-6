// TC: O(m*n)
// SC: O(m*n) when the grid is skewed and all the elements are in the queue

import java.util.*;

public class LC417 {
class Solution {
    int x[] = {0,0,1,-1};
    int y[] = {1,-1,0,0};

    class Pair{
        int i,j;
        public Pair(int a, int b){
            i=a;
            j=b;
        }
    }

    private void bfs(int heights[][], int grid[][], Queue<Pair> q, int marker, int m, int n){
        while(!q.isEmpty()){
            Pair p = q.poll();
            int cI = p.i;
            int cJ = p.j;
            for(int k=0;k<4;k++){
                int newI = cI + x[k];
                int newJ = cJ + y[k];
                if(newI<0 || newJ<0 || newI>=m || newJ>=n) continue;
                if(grid[newI][newJ]>=marker) continue;
                if(heights[newI][newJ]<heights[cI][cJ]) continue;
                grid[newI][newJ] += marker;
                q.add(new Pair(newI, newJ));
            }
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        if(heights==null || heights[0].length==0) return ans;
        int m = heights.length;
        int n = heights[0].length;
        int grid[][] = new int[m][n];
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0) {
                    grid[i][j] += 1;
                    q.add(new Pair(i,j));
                }
            }
        }
        bfs(heights, grid, q, 1, m, n);
        
        for(int i=0;i<m;i++){
            for(int j =0;j<n;j++){
                if(i==m-1 || j==n-1) {
                    grid[i][j] += 2;
                    q.add(new Pair(i,j));
                }
            }
        }
        bfs(heights, grid, q, 2, m, n);

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==3){
                    ans.add(new ArrayList<>(Arrays.asList(i, j)));
                }
            }
        }
        return ans;
    }
}