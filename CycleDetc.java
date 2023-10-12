import java.util.*;

class CycleDetc
{
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] vis=new boolean[V];
        Arrays.fill(vis,false);
        for(int i=0;i<V;i++)
        {
            if(vis[i]==false)
            {
                if(checkForCycle(i,adj,vis))
                return true;
            }
        }
        return false;
    }
    boolean checkForCycle(int index, ArrayList<ArrayList<Integer>> adj,boolean[] vis)
    {
        vis[index]=true;
        Queue<Pair> queue=new LinkedList<>();
        queue.add(new Pair(index,-1));
        while(!queue.isEmpty())
        {
            int  node=queue.peek().index;
            int parent=queue.peek().parent;
            queue.remove();
            for(int adjNodes:adj.get(node))
            {
                if(vis[adjNodes]==false)
                {
                    vis[adjNodes]=true;
                    queue.add(new Pair(adjNodes, node));
                }
                else if(parent!=adjNodes)
                {
                //cycle found
                return true;
                }
            }
          
        }
          return false;

    }
    class Pair{
        int index;
        int parent;
        Pair(int index,int parent)
        {
            this.index=index;
            this.parent=parent;
        }
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
                
        CycleDetc obj = new CycleDetc();
        boolean ans = obj.isCycle(4, adj);
        if (ans)
            System.out.println("1");    
        else
            System.out.println("0");
    }
}