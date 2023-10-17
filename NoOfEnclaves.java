public class NoOfEnclaves {


    //DFS //SAME AS REPLACE 0 WITH X gfg sum
   static int numberOfEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        for(int i=0;i<n;i++)
        {
            if(vis[i][0]==0 && grid[i][0]==1)
            {
                dfs(i,0,grid,vis);
            }
        }
         for(int i=0;i<m;i++)
        {
            if(vis[0][i]==0 && grid[0][i]==1)
            {
                dfs(0,i,grid,vis);
            }
        }
         for(int i=0;i<n;i++)
        {
            if(vis[i][m-1]==0 && grid[i][m-1]==1)
            {
                dfs(i,m-1,grid,vis);
            }
        }
         for(int i=0;i<m;i++)
        {
            if(vis[n-1][i]==0 && grid[n-1][i]==1)
            {
                dfs(n-1,i,grid,vis);
            }
        }
        int count=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1 && vis[i][j]==0)
                {
                    count++;
                }
            }
        }
        return count;
       

    }
    static void dfs(int i,int j,int[][]grid,int[][]vis)
    {
        int n=grid.length;
        int m=grid[0].length;
        vis[i][j]=1;
        int delrow[]={-1,0,+1,0};
        int delcol[]={0,+1,0,-1};
        for(int k=0;k<4;k++)
        {
            int nrow=i+delrow[k];
            int ncol=j+delcol[k];
            if(nrow<n && nrow>=0 && ncol<m && ncol>=0 &&
            vis[nrow][ncol]==0 && grid[nrow][ncol]==1)
            {
                dfs(nrow, ncol, grid, vis);
            }
        }
    }
    
}
