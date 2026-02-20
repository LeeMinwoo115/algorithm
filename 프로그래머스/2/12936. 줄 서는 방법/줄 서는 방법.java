import java.util.*;

class Solution {
    
    public int[] solution(int n, long k) {
        long[] fact = new long[n + 1];
        fact[0] = 1;
        
        for(int i=1; i<=n; i++) {
            fact[i] = fact[i - 1] * i;
        }
        
        List<Integer> nums = new ArrayList<>();
        
        for(int i=1; i<=n; i++) {
            nums.add(i);
        }
        
        int[] answer = new int[n];
        
        long idx = k - 1;
        
        for (int i = 0; i<n; i++) {
            long block = fact[n - 1 - i];
            int pickIndex = (int)(idx / block);
            idx = idx%block;
            
            answer[i] = nums.remove(pickIndex);
        }
        
        return answer;
    }
}