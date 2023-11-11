import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlight {

     public int CheapestFLight(int n,int flights[][],int src,int dst,int k) {
        
        
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        int m=flights.length;
         for(int i = 0;i<n;i++) {
            adj.add(new ArrayList<>()); 
        }
        for(int i=0;i<m;i++)
        {
            adj.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
        }
        int[] dist=new int[n];
        for(int i=0;i<n;i++)
        {
            dist[i]=(int)(1e9);
        }
        Queue<Tuple> queue=new LinkedList<>();
        queue.add(new Tuple(0,src,0)); //stops,src,dist
        dist[src]=0;
        
        
        
        while(!queue.isEmpty())
        {
            Tuple t=queue.peek();
            queue.remove();
            int stop=t.stop;
            int node=t.node;
            int price=t.price;
            
            if(stop>k)
            continue;
            
            for(Pair p :adj.get(node))
            {
                int adjn=p.adj;
                int cost=p.cost;
                if(price+cost<dist[adjn] && stop<=k)
                {
                    dist[adjn]=price+cost;
                    queue.add(new Tuple(stop+1,adjn,price+cost));
                }
            }
       
        }
             if(dist[dst]==(int)(1e9))
            return -1;
            
            return dist[dst];
        
    }
    class Pair
    {
        int adj;
        int cost;
        Pair(int a,int c)
        {
            this.adj=a;
            this.cost=c;
        }
    }
    class Tuple
    {
        int stop;
        int node;
        int price;
        Tuple(int s,int n,int p)
        {
            this.stop=s;
            this.node=n;
            this.price=p;
        }
    }
    
}
