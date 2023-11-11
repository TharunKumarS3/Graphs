import java.util.PriorityQueue;

public class PathWithMinEffort {


    int MinimumEffort(int heights[][]) {
        
        PriorityQueue<Pair> pq=new PriorityQueue<Pair>((x,y) ->x.dist - y.dist);
        
        int n=heights.length;
        int m=heights[0].length;
        int[][] d=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                d[i][j]=(int)(1e9);
            }
        }
        pq.add(new Pair(0,0,0));
        int[] delrow={-1,0,+1,0};
        int[] delcol={0,+1,0,-1};
        while(!pq.isEmpty())
        {
            Pair p=pq.peek();
            pq.remove();
            int dis=p.dist;
            int row=p.row;
            int col=p.col;
            
            if(row==n-1 && col==m-1)
            return dis;
            
            for(int i=0;i<4;i++)
            {
                int nrow=row+delrow[i];
                int ncol=col+delcol[i];
                
                
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m )
                {
                    int newdis=Math.max(Math.abs(heights[nrow][ncol]-heights[row][col]),dis);
                     if(newdis<d[nrow][ncol])
                {
                    d[nrow][ncol]=newdis;
                    pq.add(new Pair(newdis,nrow,ncol));
                }
                }
               
            }
        }

        return 0;
        
    }
    class Pair
    {
        int dist;
        int row;
        int col;
        Pair(int d,int r,int c)
        {
            this.dist=d;
            this.row=r;
            this.col=c;
        }
    }

    
}
