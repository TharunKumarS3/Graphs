import java.util.*;
public class RottenOrange {

    //GFG

    class Pair
    {
        int r;
        int c;
        int tm;
        Pair(int r,int c,int tm)
        {
            this.r=r;
            this.c=c;
            this.tm=tm;

        }
    }

    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<Pair> queue=new LinkedList<>();
        int[][] vis=new int[n][m];
        int countOne=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==2)
                {
                    queue.add(new Pair(i, j, 0));
                    vis[i][j]=2;

                }
                else if(grid[i][j]==1)
                {
                    countOne++;
                }
                else
                {
                    vis[i][j]=0;
                }
            }
        }
        int tm=0;
        int count=0;
        int[] delrow={-1,0,+1,0};
        int[] delcol={0,+1,0,-1};
        while(!queue.isEmpty())
        {
            int r=queue.peek().r;
            int c=queue.peek().c;
            int t=queue.peek().tm;
            tm=Math.max(tm,t);
            queue.remove();

            //4 directions
            for(int i=0;i<4;i++)
            {
                int nrow=r+delrow[i];
                int ncol=c+delcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m &&
                    vis[nrow][ncol]==0 && grid[nrow][ncol]==1)
                    {
                        queue.add(new Pair(nrow, ncol, t+1));
                        vis[nrow][ncol]=2;
                        count++;
                    }

            }

        }
        if(countOne!=count)
        return -1;
        return tm;


    }
    public static void main(String[] args) {
        int[][] grid =  {{0,1,2},{0,1,2},{2,1,1}};
   
        RottenOrange obj = new RottenOrange();
       int ans = obj.orangesRotting(grid);
       System.out.println(ans);
     }
    
}
