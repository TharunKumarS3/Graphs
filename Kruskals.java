import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskals {


    class Disjoint
    {
        ArrayList<Integer> parent=new ArrayList<>();
        ArrayList<Integer> rank=new ArrayList<>();
        public Disjoint(int n)
        {
            for(int i=0;i<=n;i++)
            {
               parent.add(i);
                rank.get(0);
            }
        }
        public int findUPar(int node)
        {
            if(node==parent.get(node))
            return node;

            int ulParent=findUPar(parent.get(node));
            parent.set(node, ulParent);
            return parent.get(node);
        }
        public void unionByRank(int u,int v)
        {
            int upar=findUPar(u);
            int vpar=findUPar(v);
            if(upar==vpar)
            return ;

            if(rank.get(vpar)>rank.get(upar))
            parent.set(upar, vpar);

            else if(rank.get(upar)>rank.get(vpar))
            parent.set(vpar, upar)
            else
            {
                parent.set(vpar,upar);
                int ranku=rank.get(upar);
                rank.set(upar, ranku+1);
            }

        }

    }
    class Edge implements Comparable<Edge> {
        int src, dest, weight;
        Edge(int _src, int _dest, int _wt) {
            this.src = _src; this.dest = _dest; this.weight = _wt;
        }
        // Comparator function used for
        // sorting edgesbased on their weight
        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    };

    static int spanningTree(int V,
                            ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        List<Edge> edges = new ArrayList<Edge>();
        // O(N + E)
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                int adjNode = adj.get(i).get(j).get(0);
                int wt = adj.get(i).get(j).get(1);
                int node = i;
                Edge temp = new Edge(i, adjNode, wt);
                edges.add(temp);
            }
        }
        Disjoint ds = new Disjoint(V);
        // M log M
        Collections.sort(edges);
        int mstWt = 0;
        // M x 4 x alpha x 2
        for (int i = 0; i < edges.size(); i++) {
            int wt = edges.get(i).weight;
            int u = edges.get(i).src;
            int v = edges.get(i).dest;

            if (ds.findUPar(u) != ds.findUPar(v)) {
                mstWt += wt;
                ds.unionByRank(u, v);
            }
        }

        return mstWt;
    }




    
}

