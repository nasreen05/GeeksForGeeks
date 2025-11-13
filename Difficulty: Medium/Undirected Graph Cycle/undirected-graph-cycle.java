import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Build adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[V];

        // Check each component of the graph
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (bfsCycleCheck(i, adj, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean bfsCycleCheck(int start, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, -1});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] nodeInfo = queue.poll();
            int node = nodeInfo[0], parent = nodeInfo[1];

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(new int[]{neighbor, node});
                } else if (neighbor != parent) {
                    return true; // cycle detected
                }
            }
        }
        return false;
    }
}
