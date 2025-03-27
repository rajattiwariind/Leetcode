import java.util.*;

class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        
        // Step 1: Find the dominant element in the entire array
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        int dominant = -1, maxFreq = 0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() * 2 > n) {
                dominant = entry.getKey();
                maxFreq = entry.getValue();
                break;
            }
        }
        
        // Step 2: Iterate through the array to find the minimum valid split index
        int leftCount = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i) == dominant) {
                leftCount++;
            }
            int leftSize = i + 1;
            int rightCount = maxFreq - leftCount;
            int rightSize = n - leftSize;
            
            if (leftCount * 2 > leftSize && rightCount * 2 > rightSize) {
                return i;
            }
        }
        
        return -1;
    }
}
