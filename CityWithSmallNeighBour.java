public class CityWithSmallNeighBour {

    int findCity(int n, int m, int[][] edges,int distanceThreshold)
    {
        //code here
        //creating dist[][]
        int[][] dist=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                dist[i][j]=(int)(1e9);
            }
        }
        //filling weights
        for(int i=0;i<m;i++)
        {
            int node=edges[i][0];
            int adj=edges[i][1];
            int wt=edges[i][2];
            dist[node][adj]=wt;
            dist[adj][node]=wt;
        }
        //filling 0 for same nodes
        for(int i=0;i<n;i++)
        {
            dist[i][i]=0;
        }
        //flyod warshall ago
        for(int via=0;via<n;via++)
        {
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(dist[i][via]==(int)(1e9) || dist[via][j]==(int)(1e9))
                    continue;
                    
                    dist[i][j]=Math.min(dist[i][j],dist[i][via]+dist[via][j]);
                }
            }
        }
        int maxcity=n;
        int city=-1;
        for(int i=0;i<n;i++)
        {
            int count=0;
            for(int j=0;j<n;j++)
            {
                if(dist[i][j]<=distanceThreshold)
                {
                    count++;
                }
            }
            if(count<=maxcity)
            {
                maxcity=count;
                city=i;
            }
        }
        return city;
    }
    
}
