class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int[] gaps = new int[n + 1];
        
        //gaps before the first meeting
        gaps[0] = startTime[0];

        for (int i = 1; i < n; i++) {
            gaps[i] = startTime[i] - endTime[i - 1];
        }

        //gaps after the last meeting
        gaps[n] = eventTime - endTime[n - 1];
    

        int maxFreeTime = 0;
        int curWindowSum = 0;
        int l = 0;

    
        for (int r = 0; r < gaps.length; r++) {
            curWindowSum += gaps[r];

            //if window size exceeds K + 1
            //shrink from the left
            if (r - l + 1 > k + 1) {
              curWindowSum -= gaps[l];
              l++;
            }

            //window size is exacly k +1 
            //check for max
            if (r - l + 1 == k + 1) {
                maxFreeTime = max(maxFreeTime, curWindowSum);
            }
        }
        return maxFreeTime;
    }

    public int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }
}
