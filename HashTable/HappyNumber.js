function isHappy(n) {
    function sumOfSquares(num) {
        let sum = 0;
        while (num > 0) {
            let digit = num % 10;
            sum += digit * digit;
            num = Math.floor(num / 10);
        }
        return sum;
    }
    let seen = new Set();
    while (n !== 1) {
        n = sumOfSquares(n);
        if (seen.has(n)) {
            return false; 
        }
        seen.add(n);
    }
    return true;
}
console.log(isHappy(19)); 
console.log(isHappy(2)); 
