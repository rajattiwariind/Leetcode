function climbStairs(n) {
    if (n === 0) return 0; 
    if (n === 1) return 1; 
    let dp = [0, 1, 2];
    
    for (let i = 3; i <= n; i++) {
        dp[i % 3] = dp[(i - 1) % 3] + dp[(i - 2) % 3]; 
    }
    return dp[n % 3];
}
console.log(climbStairs(5));
