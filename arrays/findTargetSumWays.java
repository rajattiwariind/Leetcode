class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums, 0, 0, target);
    }

    private int helper(int[] nums, int index, int curSum, int target) {
        if (index == nums.length) {
            if (curSum == target) {
                return 1;
            } else {
                return 0; 
            }
        }
        int left = helper(nums, index + 1, curSum + nums[index], target); // Add 
        int right = helper(nums, index + 1, curSum - nums[index], target); // 
        return left + right;
    }
}
