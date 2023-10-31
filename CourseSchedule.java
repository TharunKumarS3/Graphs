import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {
     public boolean isPossible(int N,int P, int[][] prerequisites)
    {
        // Your Code goes here
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int n=prerequisites.length;

        //creating adj list
        for(int i=0;i<N;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<P;i++)
        {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        int[] indegree=new int[N];

        //counting indegree
        for(int i=0;i<N;i++)
        {
            for(int it:adj.get(i))
            {
                indegree[it]++;
            }
        }
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<N;i++)
        {
            if(indegree[i]==0)
            {
                queue.add(i);
            }
        }
        ArrayList<Integer> topo=new ArrayList<>();
        while(!queue.isEmpty())
        {
            int node=queue.peek();
            queue.remove();
            topo.add(node);
            
            for(int it:adj.get(node))
            {
                indegree[it]--;
                if(indegree[it]==0)
                {
                    queue.add(it);
                }
            }
        }
        //no cycle
        if(topo.size()==N)
        return true;

        //cycle
        return false;
    }
 
}
