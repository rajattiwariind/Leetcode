class Solution(object):
    def countGood(self, nums, k):
        from collections import defaultdict

        count = defaultdict(int)
        total = 0  # total good pairs in current window
        left = 0
        res = 0

        for right in range(len(nums)):
            total += count[nums[right]]
            count[nums[right]] += 1

            while total >= k:
                res += len(nums) - right
                count[nums[left]] -= 1
                total -= count[nums[left]]
                left += 1

        return res
