import java.util.*;
public class CycleDetect {
    //DFS

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] vis=new boolean[V];
        Arrays.fill(vis,false);
        for(int i=0;i<V;i++)
        {
            if(!vis[i])
            {
                if(dfs(i,-1,adj,vis))
                {
                    return true;
                }
            }
        }
        return false;

    }
    public boolean dfs(int node,int parent,ArrayList<ArrayList<Integer>> adj,boolean[] vis)
    {
        vis[node]=true;
        for(int i:adj.get(node))
        {
            if(!vis[i])
            {
                if(dfs(i, node, adj, vis))
                {
                    return true;
                }

            }
            else if(i!=parent)
            {
                return true;
            }
        }
        return false;

    }
    public static void main(String[] args)
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
       // adj.get(3).add(1);
        
                
        CycleDetect obj = new CycleDetect();
        boolean ans = obj.isCycle(4, adj);
        if (ans)
            System.out.println("1");    
        else
            System.out.println("0");
    }
    
}
