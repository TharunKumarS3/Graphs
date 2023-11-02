public class ShortestPathUDG
{
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        
        //BFS bcoz the weight is 1 for every node
        //so use bfs
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
         for(int i = 0;i<n;i++) {
            adj.add(new ArrayList<>()); 
        }
        
        //converting into adj list
        for(int i=0;i<m;i++)
        {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        int[] dis=new int[n];
        for(int i=0;i<n;i++)
        {
            dis[i]=(int)1e9;
        }
        dis[src]=0;
        Queue<Integer> queue=new LinkedList<>();
        queue.add(src);
        while(!queue.isEmpty())
        {
            int node=queue.peek();
            queue.remove();
            for(int it:adj.get(node))
            {
                if(dis[node] + 1 < dis[it])
                {
                    dis[it]=1 + dis[node];
                    queue.add(it);
                }
            }
        }
        for(int i=0;i<dis.length;i++)
        {
            if(dis[i]==(int)1e9)
            dis[i]=-1;
        }
        return dis;
    }





}