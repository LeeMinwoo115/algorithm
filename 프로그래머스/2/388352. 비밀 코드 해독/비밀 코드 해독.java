import java.util.*;

class Solution {
    public int solution(int n, int[][] q, int[] ans) {
        int[] answer = new int[1];
        
        List<Integer> picked = new ArrayList<>();
        
        dfs(1, n, q, ans, picked, answer);
        
        return answer[0];
    }
    
    private void dfs(int start, int n, int[][] q, int[] ans, List<Integer> picked, int[] answer) {
        if (picked.size() == 5) {
            if (isValid(picked, q, ans)) {
                answer[0]++;
                return;
            }
        }
        
        int need = 5 - picked.size();
        
        for (int i=start; i<=n; i++) {
            picked.add(i);
            dfs(i + 1, n, q, ans, picked, answer);
            picked.remove(picked.size() - 1);
        }
    }
    
    private boolean isValid(List<Integer> picked, int[][] q, int[] ans) {
        boolean[] in = new boolean[31];
        
        for(int v: picked) {
            in[v] = true;
        }
        
        for (int i=0; i<q.length; i++) {
            int cnt = 0;
            for(int j=0; j<5; j++) {
                if (in[q[i][j]]) {
                    cnt++;
                }
            }
            
            if (cnt != ans[i]) {
                return false;
            }
        }
        
        return true;
    }
}