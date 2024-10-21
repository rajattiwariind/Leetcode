class Solution {
    public int removeDuplicates(int[] num) {
        int j=1;
        for(int i=1;i<num.length;i++){
            if(num[i]!=num[i-1]){
                num[j]=num[i];
                j++;
            }
        }
        return j;
    }
}
