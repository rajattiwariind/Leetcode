class Solution {
    public void moveZeroes(int[] nums) {
        if(nums.length==0){
            return;
        }
        int j=0;
        int count =0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                count++;
                continue;
            }else{
                nums[j++] = nums[i];
            }
        }
        //int n = nums.length-count;
        for(int i=j;i<nums.length;i++){
            nums[j++] = 0;
        }

    }
}
