class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder res = new StringBuilder(s);
        int n = part.length();

        while(true){
            int i = res.indexOf(part);
            if(i==-1){
                break;
            }else{
                res.delete(i,i+n);
            }
        }
        return res.toString();
    }
}
