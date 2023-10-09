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
}