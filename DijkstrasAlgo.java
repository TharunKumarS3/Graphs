import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstrasAlgo {

     static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        //creating Priority Queue
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y) -> x.distance - y.distance);
        int []dist = new int[V]; 
      
        // Initialising distTo list with a large number to
        // indicate the nodes are unvisited initially.
        // This list contains distance from source to the nodes.
        for(int i = 0;i<V;i++) dist[i] = (int)(1e9); 
        
        // Source initialised with dist=0.
        dist[S] = 0;
        pq.add(new Pair(0,S));
        while(pq.size() != 0) {
            int dis = pq.peek().distance; 
            int node = pq.peek().node; 
            pq.remove(); 
            
            // Check for all adjacent nodes of the popped out
            // element whether the prev dist is larger than current or not.
            for(int i = 0;i<adj.get(node).size();i++) {
                int edgeWeight = adj.get(node).get(i).get(1); 
                int adjNode = adj.get(node).get(i).get(0); 
                
                // If current distance is smaller,
                // push it into the queue.
                if(dis + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = dis + edgeWeight; 
                    pq.add(new Pair(dist[adjNode], adjNode)); 
                }
            }
        }
        // Return the list containing shortest distances
        // from source to all the nodes.
        return dist; 




    }
    class Pair
    {
        int node;
        int distance;
        public Pair(int distance,int node){
        this.node = node;
        this.distance = distance;
    }
    }
    
}
