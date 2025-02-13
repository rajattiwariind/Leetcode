import java.util.PriorityQueue;

class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        
        // Add elements to Min Heap
        for (int num : nums) {
            minHeap.add((long) num);
        }

        int operations = 0;

        // Process until the smallest element is at least k
        while (minHeap.size() >= 2 && minHeap.peek() < k) {
            long num1 = minHeap.poll(); // Extract smallest
            long num2 = minHeap.poll(); // Extract second smallest

            long newElement = (num1 * 2) + num2; // Merge elements
            minHeap.add(newElement); // Add new element back to heap
            
            operations++; // Increment operation count
        }

        return operations;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {428601626, 238548602, 38831401, 434449078, 857643266, 671951583};
        int k = 500000000;  // Example threshold

        int result = solution.minOperations(nums, k);
        System.out.println("Minimum Operations: " + result);
    }
}
