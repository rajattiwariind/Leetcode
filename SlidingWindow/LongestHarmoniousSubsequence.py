class Solution:
    def findLHS(self, nums: List[int]) -> int:
        if not nums:
            return 0
        
        freq = {}
        for num in nums:
            freq[num] = freq.get(num, 0) + 1
        
        max_length = 0
        for key in freq:
            if key + 1 in freq:
                current_length = freq[key] + freq[key + 1]
                max_length = max(max_length, current_length)
        
        return max_length
