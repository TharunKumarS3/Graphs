import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class NoOfWaysToArriveDest {



    class Pair{
    int node ;
    long time ; 
    Pair(int node, long time)
    {
        this.node= node;
        this.time = time;
    }
}


    static int countPaths(int n, List<List<Integer>> roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        int mod= (int)(1e9+7);
        for(int i =0 ; i< n ; i++)
        adj.add(new ArrayList<>());
        
        for(int i =0 ; i< roads.size(); i++)
        {
              adj.get(roads.get(i).get(0)).add(new Pair(roads.get(i).get(1),(long)roads.get(i).get(2)));
              adj.get(roads.get(i).get(1)).add(new Pair(roads.get(i).get(0),(long)roads.get(i).get(2)));
      }
        long dij[] = new long[n];
        Arrays.fill(dij,Long.MAX_VALUE);
        dij[0]=0;
        PriorityQueue<Pair> que = new PriorityQueue<>((x, y) -> Long.compare(x.time, y.time));

        que.offer(new Pair(0,0));
        int ways[] = new int[n];
        Arrays.fill(ways,0);
        ways[0]=1;
        while(!que.isEmpty())
        {
           
            Pair p = que.poll();
            int node = p.node;
            long time = p.time;
            if(node == n-1)continue;
            for(Pair pair : adj.get(node))
            {
                long ntime =(pair.time+time);
               
                if(ntime<dij[pair.node])
                {
                  ways[pair.node]=ways[node];
                dij[pair.node]=ntime;
                que.offer(new Pair(pair.node,ntime));

                }
                else
                    if(ntime==dij[pair.node])
                    {
                        ways[pair.node]=(ways[pair.node]+ways[node])%mod;
                    }
            }
          
            
        }
        
      return ways[n-1]%mod;
    }
}
    

