import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class BFS
{
    public ArrayList<Integer> bfsGraph(int v,ArrayList<ArrayList<Integer>> adj)
    {
        ArrayList<Integer>bfs=new ArrayList<>();
        boolean[] vis=new boolean[v+1];
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(0);
        vis[0]=true; 

        while(!queue.isEmpty())
        {
            Integer node=queue.poll();
            bfs.add(node);
            for(Integer num:adj.get(node))
            {
                if(vis[num]==false)
                {
                    vis[num]=true;
                    queue.add(num);
                }

            }
        }
        return bfs;


    }
    public static void main(String args[]) {

        ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(4);
        adj.get(4).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(1).add(3);
        adj.get(3).add(1);
        
        BFS sl = new BFS(); 
        ArrayList < Integer > ans = sl.bfsGraph(5, adj);
        int n = ans.size(); 
        for(int i = 0;i<n;i++) {
            System.out.print(ans.get(i)+" "); 
        }
    }
}