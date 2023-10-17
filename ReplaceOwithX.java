public class ReplaceOwithX {
    //DFS
    //CHECKING TE BOUNDARY 1ST IF FOUND O THEN DO DFS FOR ITS INDEX AND MARK VISITED IN VISITED MATRIX
    //THEN TRAVERSE TO REMAINING MATRIX IF FOUND O AND NOT VISITED MARK IT AS X

    //SAME IN LEETCODE 110
    static char[][] fill(int n,int m, char[][] mat)
    {
        int[][] vis=new int[n][m];
        for(int i=0;i<n;i++)
        {
            if(vis[i][0]==0 && mat[i][0]=='O')
            {
                dfs(i,0,mat,vis);
            }
        }
         for(int i=0;i<m;i++)
        {
            if(vis[0][i]==0 && mat[0][i]=='O')
            {
                dfs(0,i,mat,vis);
            }
        }
         for(int i=0;i<n;i++)
        {
            if(vis[i][m-1]==0 && mat[i][m-1]=='O')
            {
                dfs(i,m-1,mat,vis);
            }
        }
         for(int i=0;i<m;i++)
        {
            if(vis[n-1][i]==0 && mat[n-1][i]=='O')
            {
                dfs(n-1,i,mat,vis);
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(mat[i][j]=='O' && vis[i][j]==0)
                {
                    mat[i][j]='X';
                }
            }
        }
        return mat;
    }
    static void dfs(int i,int j,char[][]grid,int[][]vis)
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
            vis[nrow][ncol]==0 && grid[nrow][ncol]=='O')
            {
                dfs(nrow, ncol, grid, vis);
            }
        }
    }
    
}
