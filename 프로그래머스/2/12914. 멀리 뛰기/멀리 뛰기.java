class Solution {
    
    final long CONST = 1234567;
    public long solution(int n) {
        long answer = 0;
        
        long pre = 1;
        long suf = 2;
        
        if(n==1)    return 1;
        if(n==2)    return 2;
        
        for(int i=3;i<=n;i++){
            answer = (pre+suf)%CONST;
            pre = suf;
            suf = answer;
        }
        
        return answer;
    }
    
}