import java.util.*;

public class Solution {

    static class Edge {
        int to, weight;
        Edge(int to, int w) {
            this.to = to;
            this.weight = w;
        }
    }

    private int[] dijkstra(int src, int V, List<Edge>[] graph) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, src});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curDist = cur[0], u = cur[1];
            if (curDist > dist[u]) continue;

            for (Edge e : graph[u]) {
                int v = e.to, w = e.weight;
                int newDist = curDist + w;

                if (newDist < dist[v]) {
                    dist[v] = newDist;
                    pq.offer(new int[]{newDist, v});
                }
            }
        }

        return dist;
    }

    public int shortestPath(int V, int a, int b, int[][] edges) {

        @SuppressWarnings("unchecked")
        List<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++)
            graph[i] = new ArrayList<>();

        List<int[]> curvedEdges = new ArrayList<>();

        for (int[] e : edges) {
            int u = e[0], v = e[1], w1 = e[2], w2 = e[3];

            graph[u].add(new Edge(v, w1));
            graph[v].add(new Edge(u, w1));

            curvedEdges.add(new int[]{u, v, w2});
        }

        int[] distA = dijkstra(a, V, graph);
        int[] distB = dijkstra(b, V, graph);

        int ans = distA[b];

        for (int[] ce : curvedEdges) {
            int u = ce[0], v = ce[1], w2 = ce[2];

            if (distA[u] != Integer.MAX_VALUE && distB[v] != Integer.MAX_VALUE)
                ans = Math.min(ans, distA[u] + w2 + distB[v]);

            if (distA[v] != Integer.MAX_VALUE && distB[u] != Integer.MAX_VALUE)
                ans = Math.min(ans, distA[v] + w2 + distB[u]);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
