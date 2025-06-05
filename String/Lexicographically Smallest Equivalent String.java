class Solution {
    int[] parent = new int[26]; // class-level parent array for 26 lowercase letters
    
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        // Initialize each character to be its own parent
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        // Union the pairs from s1 and s2
        for (int i = 0; i < s1.length(); i++) {
            union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }

        // Build the result string
        StringBuilder result = new StringBuilder();
        for (char c : baseStr.toCharArray()) {
            char smallestChar = (char) (find(c - 'a') + 'a');
            result.append(smallestChar);
        }

        return result.toString();
    }

    // Find function with path compression
    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    // Union function that always keeps the lexicographically smaller character as representative
    private void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py) return;
        if (px < py) {
            parent[py] = px;
        } else {
            parent[px] = py;
        }
    }
}
