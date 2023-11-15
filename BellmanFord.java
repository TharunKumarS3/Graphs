import java.util.ArrayList;

public class BellmanFord {

     static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        // Write your code here
        
        int[] dis=new int[V];
        for(int i=0;i<V;i++)
        {
            dis[i]=(int)(1e8);
        }
        dis[S]=0;
        //run N-1 time loop
        for(int i=0;i<V-1;i++)
        {
            //take adj node
            for(ArrayList<Integer> it:edges)
            {
                int node=it.get(0);
                int dest=it.get(1);
                int w=it.get(2);
                if(dis[node]!=(int)(1e8) && dis[node]+w<dis[dest])
                {
                    dis[dest]=dis[node]+w;
                }
                
            }
        }
        //if negative cycle
        for(ArrayList<Integer> it:edges)
        {
            int node=it.get(0);
            int dest=it.get(1);
            int w=it.get(2);
            if(dis[node]!=1e8 && dis[node]+w <dis[dest])
            {
                int[] temp=new int[1];
                temp[0]=-1;
                return temp;
            }
        }
        return dis;
    }
    
}
