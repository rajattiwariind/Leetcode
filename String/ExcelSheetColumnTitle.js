/**
 * @param {number} columnNumber
 * @return {string}
 */
function convertToTitle(columnNumber) {
    let title = '';
    
    while (columnNumber > 0) {
      
        columnNumber--; 
        const remainder = columnNumber % 26;
        title = String.fromCharCode(remainder + 65) + title; 
        columnNumber = Math.floor(columnNumber / 26);
    }
    
    return title;
}

const columnNumber = 28; 
const columnTitle = convertToTitle(columnNumber);
console.log(columnTitle);
