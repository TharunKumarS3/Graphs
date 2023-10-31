import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleII {

     public int[] findOrder(int n, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int[] indegree=new int[n];
        int m=prerequisites.length;
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++)
        {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        for(int i=0;i<n;i++)
        {
            for(int it:adj.get(i))
            {
                indegree[it]++;
            }
        }
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            if(indegree[i]==0)
            queue.add(i);

        }
        int[] topo=new int[n];
        int i=0;
        while(!queue.isEmpty())
        {
            int node=queue.peek();
            queue.remove();
            topo[i++]=node;

            for(int it:adj.get(node))
            {
                indegree[it]--;
                if(indegree[it]==0)
                queue.add(it);
            }
        }
        if(i==n)
        return topo;
        int[] ans={};
        return ans;

    }
    
}
