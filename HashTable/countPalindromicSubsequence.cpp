class Solution {
public:
    int countPalindromicSubsequence(string s) {
        bitset<26> e;
        int ans=0;
        for(int i=0;i<26;i++){
            int l=s.find('a'+i);
            if(l!=string::npos){
                int r=s.find_last_of('a'+i);
                if(r-l<2)continue;
                for(int j=l+1;j<r;j++){
                    e.set(s[j]-'a');
                    if(e.count()== 26)break;
                }
                ans+=e.count();
                e.reset();
            }
        }
        return ans;
    }
};
