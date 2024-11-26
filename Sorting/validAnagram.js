/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
function isAnagram(s, t) {
    if (s.length !== t.length) {
        return false;
    }
    let charCountS = {};
    let charCountT = {};
    for (let char of s) {
        charCountS[char] = (charCountS[char] || 0) + 1;
    }
    for (let char of t) {
        charCountT[char] = (charCountT[char] || 0) + 1;
    }
    for (let char in charCountS) {
        if (charCountS[char] !== charCountT[char]) {
            return false; 
        }
    }

    return true;
}
