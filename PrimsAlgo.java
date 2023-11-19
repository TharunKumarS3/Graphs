import java.util.*;
class Pair {
    int node;
    int dis;

    public Pair(int node, int dis) {
        this.node = node;
        this.dis = dis;
    }
}

class PrimsAlgo {
    static int spanningTree(int V, int E, int edges[][]) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int weight = edges[i][2];
            adj.get(u).add(new Pair(v, weight));
            adj.get(v).add(new Pair(u, weight));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a , b) -> a.dis - b.dis);
        int[] vis = new int[V];
        pq.add(new Pair(0, 0));
        int sum = 0;

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int node = p.node;
            int dis = p.dis;

            if (vis[node] == 0) {
                vis[node] = 1;
                sum += dis;

                for (Pair pair : adj.get(node)) {
                    int adjnode = pair.node;
                    int weight = pair.dis;

                    if (vis[adjnode] == 0) {
                        pq.add(new Pair(adjnode, weight));
                    }
                }
            }
        }

        return sum;
    }
}
