class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<Set<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        boolean[] visited = new boolean[n];
        int completeCount = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                dfs(i, adj, visited, component);
                if (isCompleteComponent(component, adj)) {
                    completeCount++;
                }
            }
        }
        
        return completeCount;
    }
    
    private void dfs(int node, List<Set<Integer>> adj, boolean[] visited, List<Integer> component) {
        visited[node] = true;
        component.add(node);
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, component);
            }
        }
    }
    
    private boolean isCompleteComponent(List<Integer> component, List<Set<Integer>> adj) {
        int size = component.size();
        for (int node : component) {
            if (adj.get(node).size() != size - 1) {
                return false;
            }
        }
        return true;
    }
}
