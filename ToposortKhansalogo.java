import java.util.*;

public class ToposortKhansalogo {

        static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
        {
            //get all no of indegree of the node
            int[] indegree=new int[V];
            for(int i=0;i<V;i++)
            {
                for(int it:adj.get(i))
                {
                    indegree[it]++;
                }
            }

            //check if the indgree of the node ==0 then add it in queue
            Queue<Integer> queue=new LinkedList<>();
            for(int i=0;i<V;i++)
            {
                if(indegree[i]==0)
                {
                    queue.add(i);
                }
            }
            //now take the element for the queue and indegree[i]-- to reduce the indgree
            //declare array to store elements

            int[] topo=new int[V];
            int i=0;
            while(!queue.isEmpty())
            {
                int node=queue.peek();
                queue.remove();
                topo[i++]=node; //adding element to the node

                //we added the node is topo array that means it has 0 indegrees
                //so reduce its adjacency 
                for (int it  : adj.get(node)) 
                {
                    indegree[it]--;
                    if(indegree[it]==0)
                    {
                        queue.add(it);
                    }
                    
                }
                

            }
            return topo;




        }
    
}
