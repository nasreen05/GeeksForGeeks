class Solution {
    public ArrayList<Integer> safeNodes(int V, int[][] edges) {
        // Step 1: Build the adjacency list and reversed adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayList<ArrayList<Integer>> revAdj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
            revAdj.add(new ArrayList<>());
        }
        int[] outdeg = new int[V];

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            revAdj.get(edge[1]).add(edge[0]);
            outdeg[edge[0]]++;
        }
        
        // Step 2: Initialize the queue with all terminal nodes (outdeg == 0)
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (outdeg[i] == 0) q.add(i);
        }
        
        // Step 3: Apply Kahn's Algorithm in reverse
        boolean[] safe = new boolean[V];
        while (!q.isEmpty()) {
            int node = q.poll();
            safe[node] = true;
            for (int prev : revAdj.get(node)) {
                outdeg[prev]--;
                if (outdeg[prev] == 0) q.add(prev);
            }
        }
        
        // Step 4: Collect and return result
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (safe[i]) result.add(i);
        }
        return result;
    }
}