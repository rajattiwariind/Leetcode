var maxTwoEvents = function(events) {
    // Sort events by endTime
    events.sort((a, b) => a[1] - b[1]);

    let maxSingleEvent = 0; // Max value of a single event
    let maxSum = 0; // Max sum of two events
    const dp = []; // Store [endTime, maxValue] pairs

    for (const [start, end, value] of events) {
        // Binary search to find the latest event that ends before the current one starts
        let left = 0, right = dp.length - 1, idx = -1;
        while (left <= right) {
            const mid = Math.floor((left + right) / 2);
            if (dp[mid][0] < start) {
                idx = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // If we found a compatible event, consider its value
        let compatibleValue = idx !== -1 ? dp[idx][1] : 0;
        maxSum = Math.max(maxSum, compatibleValue + value);

        // Update max value of a single event
        maxSingleEvent = Math.max(maxSingleEvent, value);

        // Update dp array with the current event
        if (dp.length === 0 || dp[dp.length - 1][1] < maxSingleEvent) {
            dp.push([end, maxSingleEvent]);
        }
    }

    return maxSum;
};
