import java.util.ArrayList;

public class CycleDetectDirected {

    //DFS CYCLE DETECTION IN DIRECTED GRAPH
    //WE USE EXYRA ARRAY FOR PATH VISIT

     public boolean isCyclic(int v, ArrayList<ArrayList<Integer>> adj)
    {
        int vis[]=new int[v];
        int pathvisit[]=new int[v];
        for(int i=0;i<v;i++)
        {
            if(vis[i]==0)
            {
                if(dfs(i,vis,pathvisit,adj))
                {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean dfs(int i,int[] vis,int[] pathvisit,ArrayList<ArrayList<Integer>> adj)
    {
        vis[i]=1;
        pathvisit[i]=1;
        for(int node:adj.get(i))
        {
            if(vis[node]==0)
            {
                if(dfs(node, vis, pathvisit, adj))
                {
                    return true;
                }
            }
            if(pathvisit[node]==1)
            return true;
        }
        pathvisit[i]=0;
        return false;
    }
    
}
