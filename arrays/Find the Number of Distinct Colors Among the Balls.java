import java.util.*;

class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> ball = new HashMap<>(); // Maps position -> color
        Map<Integer, Integer> color = new HashMap<>(); // Maps color -> count
        int n = queries.length, distinct = 0;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int pos = queries[i][0], c = queries[i][1];

            // If a ball exists at the position, decrement the count of its old color
            if (ball.containsKey(pos)) {
                int oldColor = ball.get(pos);
                int oldCount = color.get(oldColor) - 1;
                if (oldCount == 0) {
                    color.remove(oldColor);
                    distinct--; // Color is completely removed
                } else {
                    color.put(oldColor, oldCount);
                }
            }

            // Place the new color at the position
            ball.put(pos, c);

            // Increment the count for the new color
            int newCount = color.getOrDefault(c, 0) + 1;
            color.put(c, newCount);
            if (newCount == 1) distinct++; // New color introduced

            // Store the number of distinct colors after this query
            ans[i] = distinct;
        }

        return ans;
    }
}
