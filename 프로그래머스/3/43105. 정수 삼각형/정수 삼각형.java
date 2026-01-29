import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        List<int[]> results = new ArrayList<>();
        
        for(int i=0; i<triangle.length; i++) {
            int[] dp = new int[triangle[i].length];
            
            if (i == 0) {
                dp[0] = triangle[i][0];
                results.add(dp);
                continue;
            }
            
            int[] previousDp = results.get(i-1);
            
            for(int j=0; j<triangle[i].length; j++) {
                if (j == 0) {
                    dp[j] = previousDp[j] + triangle[i][j];
                } else if (j == triangle[i].length - 1) {
                    dp[j] = previousDp[j-1] + triangle[i][j];
                } else {
                    dp[j] = Math.max(
                        previousDp[j-1] + triangle[i][j],
                        previousDp[j] + triangle[i][j]
                    );
                }
            }
            
            results.add(dp);
        }
        
        for(int value: results.get(results.size() - 1)) {
            answer = Math.max(value, answer);
        }
        
        return answer;
    }
}