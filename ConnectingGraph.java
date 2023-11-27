import java.util.ArrayList;
import java.util.List;

public class ConnectingGraph {


     public static class DisjointSet
    {
        private List<Integer> parent=new ArrayList<>();
        private List<Integer> rank=new ArrayList<>();
        
        public DisjointSet(int n)
        {
            for(int i=0;i<n;i++)
            {
                parent.add(i);
                rank.add(0);
            }
        }
        public int findParent(int u)
        {
            if(u==parent.get(u))
            {
                return u;
            }
            int ulparent=findParent(parent.get(u));
            parent.set(u,ulparent);
            return parent.get(u);
        }
        public void unionRank(int u,int v)
        {
            int up=findParent(u);
            int vp=findParent(v);
            if(up==vp)
            return;
            if(rank.get(up)>rank.get(vp))
            {
                parent.set(vp,up);
            }
            else if(rank.get(vp)>rank.get(up))
            {
                parent.set(up,vp);
            }
            else
            {
                parent.set(vp,up);
                int rankU=rank.get(up);
                rank.set(up,rankU+1);
            }
        }
    }

    public int Solve(int n, int[][] edge) {
        
        // Code here
        DisjointSet ds=new DisjointSet(n);
        int extraedge=0;
        int m=edge.length;
        for(int i=0;i<m;i++)
        {
            int u=edge[i][0];
            int v=edge[i][1];
            if(ds.findParent(u)==ds.findParent(v))
            extraedge++;
            else
            ds.unionRank(u,v);
        }
        int noOfParent=0;
        for(int i=0;i<n;i++)
        {
            if(ds.parent.get(i)==i)
            noOfParent++;
            
        }
        int ans=noOfParent-1;
        if(extraedge>=ans)
        return ans;
        
        return -1;
    }











    
}
