import java.util.*;

// Edge representation for convenience
class Edge {
    int u, v, w;
    Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }
}

class Solution {
    // Disjoint Set Union (Union Find)
    int[] parent, rank;
    int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }
    boolean union(int x, int y) {
        int px = find(x), py = find(y);
        if (px == py) return false;
        if (rank[px] < rank[py]) parent[px] = py;
        else {
            parent[py] = px;
            if (rank[px] == rank[py]) rank[px]++;
        }
        return true;
    }

    public int secondMST(int V, int[][] edgesArr) {
        List<Edge> edges = new ArrayList<>();
        for (int[] e : edgesArr) edges.add(new Edge(e[0], e[1], e[2]));

        // Step 1: Kruskal's MST
        Collections.sort(edges, Comparator.comparingInt(e -> e.w));
        parent = new int[V];
        rank = new int[V];
        for (int i = 0; i < V; i++) parent[i] = i;

        int mstWeight = 0, cnt = 0;
        List<Edge> mstEdges = new ArrayList<>();
        for (Edge e : edges) {
            if (union(e.u, e.v)) {
                mstWeight += e.w;
                mstEdges.add(e);
                cnt++;
            }
            if (cnt == V - 1) break;
        }
        if (cnt != V - 1) return -1; // Graph not connected

        int res = Integer.MAX_VALUE;
        // Step 2: For each edge in MST, try to replace it
        for (int i = 0; i < mstEdges.size(); i++) {
            // Remove mstEdges[i] and find MST with remaining edges
            parent = new int[V];
            rank = new int[V];
            for (int j = 0; j < V; j++) parent[j] = j;

            int total = 0, edgeCnt = 0;
            for (int j = 0; j < edges.size(); j++) {
                Edge e = edges.get(j);
                // Skip the i-th MST edge
                if (e == mstEdges.get(i)) continue;
                if (union(e.u, e.v)) {
                    total += e.w;
                    edgeCnt++;
                }
                if (edgeCnt == V - 1) break;
            }
            if (edgeCnt == V - 1 && total > mstWeight)
                res = Math.min(res, total);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
