/**
 * @param {string} s
 * @param {string} p
 * @return {boolean}
 */
function isMatch(s, p) {
  const memo = new Map();
  function dp(i, j) {
    if (memo.has(`${i},${j}`)) {
      return memo.get(`${i},${j}`);
    }
    if (i === s.length && j === p.length) {
      return true;
    }
    if (j === p.length) {
      return false;
    }
    const firstMatch = (i < s.length) && (p[j] === s[i] || p[j] === '.');

    let result;
    if (j + 1 < p.length && p[j + 1] === '*') {
      result = (dp(i, j + 2) || 
               (firstMatch && dp(i + 1, j))); 
    } else {
      result = firstMatch && dp(i + 1, j + 1);
    }
    memo.set(`${i},${j}`, result);
    return result;
  }
  return dp(0, 0);
}
