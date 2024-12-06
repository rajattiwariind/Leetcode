class Solution {

    public int maxCount(int[] banned, int n, int maxSum) {

        int[] bannedArr = new int[10001];
        for (int ban : banned) {
            bannedArr[ban] = 1; 
        }

        int count = 0;
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            
            if (bannedArr[i] == 1) continue;

            if (sum + i > maxSum) break;

            count++;
            sum += i;
        }
        return count;
    }
}
