/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
function isSubsequence(s, t) {
    let sIndex = 0; 
    let tIndex = 0; 
    while (tIndex < t.length) {
        if (s[sIndex] === t[tIndex]) {
            sIndex++;
        }
        if (sIndex === s.length) {
            return true;
        }
        tIndex++;
    }
    return sIndex === s.length;
}
