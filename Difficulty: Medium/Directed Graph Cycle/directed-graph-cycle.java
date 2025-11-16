class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        
        int[] indegree = new int[V];

        // Build graph and indegree array
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            indegree[v]++;
        }

        // Queue for nodes with indegree == 0
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) q.offer(i);
        }

        int visited = 0;

        // Process queue (Kahn's algorithm)
        while (!q.isEmpty()) {
            int node = q.poll();
            visited++;

            for (int nei : adj.get(node)) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    q.offer(nei);
                }
            }
        }

        // If visited != V, graph has a cycle
        return visited != V;
    }
}
