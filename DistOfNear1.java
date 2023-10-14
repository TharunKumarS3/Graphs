import java.util.*;
public class DistOfNear1 {

    //GFG
    public int[][] nearest(int[][] grid)
    {
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        int[][] dist=new int[n][m];
        Queue<Pair> queue=new LinkedList<>();
        //search for all 1's index and add it in queue
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)
                {
                    queue.add(new Pair(i,j,0));
                    vis[i][j]=1;
                }
                else 
                {
                    vis[i][j]=0;
                }

            }
            //to go in 4 directions
          
        }
        int[] delrow={-1,0,+1,0};
        int[] delcol={0,+1,0,-1};
        //now we remove elements one by one
        while(!queue.isEmpty())
        {
            int row=queue.peek().row;
            int col=queue.peek().col;
            int steps=queue.peek().steps;
            queue.remove();
            dist[row][col]=steps;

            //trevaling 4 direction to check for 0's
            for(int i=0;i<4;i++)
            {
                int nrow=row+delrow[i];
                int ncol=col+delcol[i];
                if(nrow<n && nrow>=0 && ncol<m && ncol>=0 && vis[nrow][ncol]==0)
                {
                    vis[nrow][ncol]=1;
                    queue.add(new Pair(nrow, ncol, steps+1));

                }
            }
            
            
        }
        return dist;


    }
    class Pair{
        int row,col,steps;
        Pair(int r,int c,int s)
        {
            this.row=r;
            this.col=c;
            this.steps=s;
        }
    }
    
}
