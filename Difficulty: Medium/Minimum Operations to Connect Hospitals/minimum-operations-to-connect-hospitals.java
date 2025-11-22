class Solution {
    public int minConnect(int V, int[][] edges) {
        int E = edges.length;
        
        // If we don't even have V-1 edges, impossible to connect all hospitals
        if (E < V - 1) return -1;
        
        // Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        boolean[] vis = new boolean[V];
        int components = 0;
        
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                components++;
                dfs(i, adj, vis);
            }
        }
        
        // Need (components - 1) operations to connect all components
        return components - 1;
    }
    
    private void dfs(int node, List<List<Integer>> adj, boolean[] vis) {
        vis[node] = true;
        for (int nei : adj.get(node)) {
            if (!vis[nei]) {
                dfs(nei, adj, vis);
            }
        }
    }
}
