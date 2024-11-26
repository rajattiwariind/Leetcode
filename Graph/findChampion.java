class Solution {
    public int findChampion(int n, int[][] edges) {
        
        int[] v = new int[n];
        int ans =-1,c=0;
        for(int[] i:edges)    
        {
             v[i[1]] ++;
        }
        for(int i=0;i<n;i++)
        {
            if(v[i]==0) 
            {
                ans=i;c++;
            }
        }
        if(c>1) return -1;
        return ans;
    }
}
