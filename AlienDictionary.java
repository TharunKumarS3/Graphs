import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class AlienDictionary {
      public String findOrder(String [] dict, int N, int K)
    {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<K;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<N-1;i++)
        {
            String s1=dict[i];
            String s2=dict[i+1];
            int len=Math.min(s1.length(),s2.length());
            for(int p=0;p<len;p++)
            {
                if(s1.charAt(p)!=s2.charAt(p))
                {
                    adj.get(s1.charAt(p)-'a').add(s2.charAt(p)-'a');
                    break;
                }
            }
        }
        
        ArrayList<Integer> topo1=new ArrayList<>();
        topo1=topo(K,adj);
        
        String ans="";
        for(int it:topo1)
        {
            ans+=(char)(it+(int)'a');
        }
        return ans;
        
    }
    static ArrayList<Integer> topo(int V,ArrayList<ArrayList<Integer>> adj)
    {
        int[] indegree=new int[V];
        for(int i=0;i<V;i++)
        {
            for(int it:adj.get(i))
            {
                indegree[it]++;
            }
        }
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<V;i++)
        {
            if(indegree[i]==0)
            queue.add(i);
        }
        
        ArrayList<Integer> toposort=new ArrayList<>();
        while(!queue.isEmpty())
        {
            int node=queue.peek();
            queue.remove();
            toposort.add(node);
            
            for(int it:adj.get(node))
            {
                indegree[it]--;
                if(indegree[it]==0)
                queue.add(it);
            }
        }
        return toposort;
    }
}
